package com.jetbrains.simpleinterpreter.model.asthandlers;

import com.jetbrains.simpleinterpreter.model.InterpretationException;
import com.jetbrains.simpleinterpreter.model.antlrgen.SimpleBaseVisitor;
import com.jetbrains.simpleinterpreter.model.antlrgen.SimpleParser;
import com.jetbrains.simpleinterpreter.model.state.ProgramState;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Visitor for AST nodes which returns numerical value. For simplicity they all stored as double.
 * @implNote Logical generic based implementation of <code>SimpleBaseVisitor&lt;Double&gt;</code> has bad performance.
 * During interpretation a lot of boxed values is generated and GC affects GUI. In current implementation all visitors
 * store their results in local field {@link visitResult} and caller get result from that field. To avoid wrong usage
 * {@link DoubleVisitor} is created.
 */
public class DoubleVisitorImpl extends SimpleBaseVisitor<Void> implements DoubleVisitor {
    private final Logger logger = LoggerFactory.getLogger(DoubleVisitorImpl.class);

    private ProgramState state;
    private VoidVisitor voidVisitor;
    private SequenceVisitor sequenceVisitor;
    private double visitResult;

    DoubleVisitorImpl(ProgramState state) {
        this.state = state;
    }

    void setVoidVisitor(VoidVisitor voidVisitor) {
        this.voidVisitor = voidVisitor;
    }

    void setSequenceVisitor(SequenceVisitor sequenceVisitor) {
        this.sequenceVisitor = sequenceVisitor;
    }

    @Override
    public Void visitOpExpression(SimpleParser.OpExpressionContext ctx) {
        if (Thread.currentThread().isInterrupted())
            throw new RuntimeException("Interrupted");

        double left = visitDouble(ctx.left);
        double right = visitDouble(ctx.right);

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
        visitResult = result;
        return null;
    }

    @Override
    public Void visitParentheses(SimpleParser.ParenthesesContext ctx) {
        visit(ctx.arg);
        return null;
    }

    @Override
    public Void visitConstant(SimpleParser.ConstantContext ctx) {
        try {
            double sign = ctx.sign == null ? 1 : -1;
            visitResult = sign * Double.parseDouble(ctx.NUMBER().getText());
            return null;
        } catch (NumberFormatException e) {
            throw new InterpretationException("Constant parse error", ctx.NUMBER().getSymbol());
        }
    }

    @Override
    public Void visitVariable(SimpleParser.VariableContext ctx) {
        TerminalNode identifier = ctx.IDENTIFIER();
        voidVisitor.commonVariableUseCheck(identifier);

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
        visitResult = result;
        return null;
    }

    @Override
    public Void visitReduce(SimpleParser.ReduceContext ctx) {
        String firstParamName = ctx.firstParam.getText();
        String secondParamName = ctx.secondParam.getText();
        if (firstParamName.equals(secondParamName))
            throw new InterpretationException("Lambda parameters should be different", ctx.secondParam);

        voidVisitor.commonNewVariableCheck(ctx.firstParam);
        voidVisitor.commonNewVariableCheck(ctx.secondParam);

        Sequence arg = sequenceVisitor.visit(ctx.arg);
        double result = visitDouble(ctx.start);
        state.getLambdaParameters().put(firstParamName, result);
        for (double secondParam : arg) {
            state.getLambdaParameters().put(secondParamName, secondParam);
            result = visitDouble(ctx.lambda);
            state.getLambdaParameters().put(firstParamName, result);

            if (Thread.currentThread().isInterrupted())
                throw new RuntimeException("Interrupted");
        }
        state.getLambdaParameters().remove(firstParamName);
        state.getLambdaParameters().remove(secondParamName);

        logger.trace("{} := {}", ctx.getText(), result);
        visitResult = result;
        return null;
    }

    @Override
    public Void visitSequenceDef(SimpleParser.SequenceDefContext ctx) {
        throw new InterpretationException("Type mismatch: expected number but was sequence", ctx);
    }

    @Override
    public Void visitMap(SimpleParser.MapContext ctx) {
        throw new InterpretationException("Type mismatch: expected number but was sequence", ctx);
    }

    @Override
    public double visitDouble(ParseTree tree) {
        visit(tree);
        return visitResult;
    }
}
