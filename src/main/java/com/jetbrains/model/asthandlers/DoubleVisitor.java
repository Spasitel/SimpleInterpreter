package com.jetbrains.model.asthandlers;

import com.jetbrains.model.InterpretationException;
import com.jetbrains.model.antlrgen.SimpleBaseVisitor;
import com.jetbrains.model.antlrgen.SimpleParser;
import com.jetbrains.model.state.ProgramState;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DoubleVisitor extends SimpleBaseVisitor<Double> {
    private final Logger logger = LoggerFactory.getLogger(DoubleVisitor.class);

    private ProgramState state;
    private VoidVisitor voidVisitor;
    private SequenceVisitor sequenceVisitor;

    DoubleVisitor(ProgramState state) {
        this.state = state;
    }

    void setVoidVisitor(VoidVisitor voidVisitor) {
        this.voidVisitor = voidVisitor;
    }

    void setSequenceVisitor(SequenceVisitor sequenceVisitor) {
        this.sequenceVisitor = sequenceVisitor;
    }

    @Override
    public Double visitOpExpression(SimpleParser.OpExpressionContext ctx) {
        double left = visit(ctx.left);
        double right = visit(ctx.right);

        double result;
        switch (ctx.op.getText().charAt(0)) {
            case '^':
                result = Math.pow(left, right);
                break;
            case '*':
                result = left * right;
                break;
            case '/':
                result = left / right;
                break;
            case '+':
                result = left + right;
                break;
            case '-':
                result = left - right;
                break;
            default:
                throw new InterpretationException("Unknown operation", ctx.op);
        }

        logger.trace("{} := {}", ctx.getText(), result);
        return result;
    }

    @Override
    public Double visitParentheses(SimpleParser.ParenthesesContext ctx) {
        return visit(ctx.arg);
    }

    @Override
    public Double visitConstant(SimpleParser.ConstantContext ctx) {
        try {
            double sign = ctx.sign == null ? 1 : -1;
            return sign * Double.parseDouble(ctx.NUMBER().getText());
        } catch (NumberFormatException e) {
            throw new InterpretationException("Constant parse error", ctx.NUMBER().getSymbol());
        }
    }

    @Override
    public Double visitVariable(SimpleParser.VariableContext ctx) {
        TerminalNode identifier = ctx.IDENTIFIER();
        commonVariableUseCheck(identifier);

        String name = identifier.getText();
        if (state.getGlobalSequenceVariables().containsKey(name))
            throw new InterpretationException("Type mismatch: expected number but was sequence",
                    identifier.getSymbol());

        double result;
        if (state.getGlobalDoubleVariables().containsKey(name)) {
            result = state.getGlobalDoubleVariables().get(name);
        } else {
            result = state.getLambdaParameters().get(name);
        }
        logger.trace("{} := {}", ctx.getText(), result);
        return result;
    }

    @Override
    public Double visitReduce(SimpleParser.ReduceContext ctx) {
        String firstParamName = ctx.firstParam.getText();
        String secondParamName = ctx.secondParam.getText();
        if (firstParamName.equals(secondParamName))
            throw new InterpretationException("Lambda parameters should be different", ctx.secondParam);

        voidVisitor.commonNewVariableCheck(ctx.firstParam);
        voidVisitor.commonNewVariableCheck(ctx.secondParam);

        List<Double> arg = sequenceVisitor.visit(ctx.arg);
        double result = visit(ctx.start);
        state.getLambdaParameters().put(firstParamName, result);
        for (double secondParam : arg) {
            state.getLambdaParameters().put(secondParamName, secondParam);
            result = visit(ctx.lambda);
            state.getLambdaParameters().put(firstParamName, result);
        }
        state.getLambdaParameters().remove(firstParamName);
        state.getLambdaParameters().remove(secondParamName);

        logger.trace("{} := {}", ctx.getText(), result);
        return result;
    }

    void commonVariableUseCheck(TerminalNode identifier) {
        String name = identifier.getText();
        boolean isGlobal = state.getGlobalDoubleVariables().containsKey(name) ||
                state.getGlobalSequenceVariables().containsKey(name);
        if (!isGlobal && !state.getLambdaParameters().containsKey(name))
            throw new InterpretationException("Variable " + name + " not found", identifier.getSymbol());

        if (!state.getLambdaParameters().isEmpty() && isGlobal)
            throw new InterpretationException("Access to global variable from lambda", identifier.getSymbol());
    }

    @Override
    public Double visitSequenceDef(SimpleParser.SequenceDefContext ctx) {
        throw new InterpretationException("Type mismatch: expected number but was sequence", ctx);
    }

    @Override
    public Double visitMap(SimpleParser.MapContext ctx) {
        throw new InterpretationException("Type mismatch: expected number but was sequence", ctx);
    }
}
