package com.jetbrains.model;

import com.jetbrains.model.antlrGen.SimpleBaseVisitor;
import com.jetbrains.model.antlrGen.SimpleParser;
import com.jetbrains.model.state.ProgramState;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class DoubleVisitor extends SimpleBaseVisitor<Double> {

    private ProgramState state;

    DoubleVisitor(ProgramState state) {
        this.state = state;
    }

    @Override
    public Double visitOpExpression(SimpleParser.OpExpressionContext ctx) {
        double left = visit(ctx.left);
        double right = visit(ctx.right);

        switch (ctx.op.getText().charAt(0)) {
            case '^':
                return Math.pow(left, right);
            case '*':
                return left * right;
            case '/':
                return left / right;
            case '+':
                return left + right;
            case '-':
                return left - right;
            default:
                throw new InterpreterException("Unknown operation", ctx.op);
        }
    }

    @Override
    public Double visitParentheses(SimpleParser.ParenthesesContext ctx) {
        return visit(ctx.arg);
    }

    @Override
    public Double visitConstant(SimpleParser.ConstantContext ctx) {
        try {
            return Double.parseDouble(ctx.NUMBER().getText());
        } catch (NumberFormatException e) {
            throw new InterpreterException("Constant parse error", ctx.NUMBER().getSymbol());
        }
    }

    @Override
    public Double visitVariable(SimpleParser.VariableContext ctx) {
        TerminalNode identifier = ctx.IDENTIFIER();
        commonVariableUseCheck(identifier);

        String name = identifier.getText();
        if (state.getGlobalSequenceVariables().containsKey(name))
            throw new InterpreterException("Type mismatch: expected number but was sequence",
                    identifier.getSymbol());

        if (state.getGlobalDoubleVariables().containsKey(name))
            return state.getGlobalDoubleVariables().get(name);
        else
            return state.getLambdaParameters().get(name);
    }

    @Override
    public Double visitReduce(SimpleParser.ReduceContext ctx) {
        String firstParamName = ctx.firstParam.getText();
        String secondParamName = ctx.secondParam.getText();
        if (firstParamName.equals(secondParamName))
            throw new InterpreterException("Lambda parameters should be different", ctx.secondParam);

        VoidVisitor voidVisitor = new VoidVisitor(state);
        voidVisitor.commonNewVariableCheck(ctx.firstParam);
        voidVisitor.commonNewVariableCheck(ctx.secondParam);

        List<Double> arg = new SequenceVisitor(state).visit(ctx.arg);
        double result = visit(ctx.start);
        state.getLambdaParameters().put(firstParamName, result);
        for (double secondParam : arg) {
            state.getLambdaParameters().put(secondParamName, secondParam);
            result = visit(ctx.lambda);
            state.getLambdaParameters().put(firstParamName, result);
        }
        state.getLambdaParameters().remove(firstParamName);
        state.getLambdaParameters().remove(secondParamName);

        return result;
    }

    void commonVariableUseCheck(TerminalNode identifier) {
        String name = identifier.getText();
        boolean isGlobal = state.getGlobalDoubleVariables().containsKey(name) ||
                state.getGlobalSequenceVariables().containsKey(name);
        if (!isGlobal && !state.getLambdaParameters().containsKey(name))
            throw new InterpreterException("Variable " + name + " not found", identifier.getSymbol());

        if (!state.getLambdaParameters().isEmpty() && isGlobal)
            throw new InterpreterException("Access to global variable from lambda", identifier.getSymbol());
    }

    @Override
    public Double visitSequenceDef(SimpleParser.SequenceDefContext ctx) {
        throw new InterpreterException("Type mismatch: expected number but was sequence", ctx);
    }

    @Override
    public Double visitMap(SimpleParser.MapContext ctx) {
        throw new InterpreterException("Type mismatch: expected number but was sequence", ctx);
    }
}
