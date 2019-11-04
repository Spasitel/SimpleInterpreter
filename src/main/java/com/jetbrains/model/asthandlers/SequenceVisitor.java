package com.jetbrains.model.asthandlers;

import com.jetbrains.model.InterpretationException;
import com.jetbrains.model.antlrgen.SimpleBaseVisitor;
import com.jetbrains.model.antlrgen.SimpleParser;
import com.jetbrains.model.state.ProgramState;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SequenceVisitor extends SimpleBaseVisitor<List<Double>> {
    private final Logger logger = LoggerFactory.getLogger(SequenceVisitor.class);

    private ProgramState state;
    private DoubleVisitor doubleVisitor;
    private VoidVisitor voidVisitor;

    SequenceVisitor(ProgramState state) {
        this.state = state;
    }

    void setDoubleVisitor(DoubleVisitor doubleVisitor) {
        this.doubleVisitor = doubleVisitor;
    }

    void setVoidVisitor(VoidVisitor voidVisitor) {
        this.voidVisitor = voidVisitor;
    }

    @Override
    public List<Double> visitSequenceDef(SimpleParser.SequenceDefContext ctx) {
        int start = getIntValue(ctx.start);
        int end = getIntValue(ctx.end);

        if (start > end)
            throw new InterpretationException("Wrong sequence: {" + start + " ," + end + "}", ctx);
        List<Double> result = new ArrayList<>();
        for (int i = start; i <= end; i++)
            result.add((double) i);

        logger.trace("{} := sequence size:{} first:{} last:{}", ctx.getText(), result.size(), result.get(0),
                result.get(result.size() - 1));
        return result;
    }

    private int getIntValue(SimpleParser.ExprContext start) {
        double value = doubleVisitor.visit(start);
        if ((value == Math.floor(value)) && !Double.isInfinite(value)) {
            return (int) value;
        }
        throw new InterpretationException("Expected integer but was: " + value, start);
    }

    @Override
    public List<Double> visitVariable(SimpleParser.VariableContext ctx) {
        TerminalNode identifier = ctx.IDENTIFIER();
        doubleVisitor.commonVariableUseCheck(identifier);

        String name = identifier.getText();
        if (state.getGlobalSequenceVariables().containsKey(name)) {
            List<Double> result = state.getGlobalSequenceVariables().get(name);
            logger.trace("{} := sequence size:{} first:{} last:{}", ctx.getText(), result.size(), result.get(0),
                    result.get(result.size() - 1));
            return result;
        }

        throw new InterpretationException("Type mismatch: expected sequence but was number", identifier.getSymbol());
    }

    @Override
    public List<Double> visitMap(SimpleParser.MapContext ctx) {
        Token param = ctx.param;
        voidVisitor.commonNewVariableCheck(param);

        List<Double> argument = visit(ctx.arg);
        List<Double> result = new ArrayList<>();
        for (double element : argument) {
            state.getLambdaParameters().put(param.getText(), element);
            result.add(doubleVisitor.visit(ctx.lambda));
        }
        state.getLambdaParameters().remove(param.getText());
        logger.trace("{} := sequence size:{} first:{} last:{}", ctx.getText(), result.size(), result.get(0),
                result.get(result.size() - 1));
        return result;
    }

    @Override
    public List<Double> visitParentheses(SimpleParser.ParenthesesContext ctx) {
        return visit(ctx.arg);
    }

    @Override
    public List<Double> visitReduce(SimpleParser.ReduceContext ctx) {
        throw new InterpretationException("Type mismatch: expected sequence but was number", ctx);
    }

    @Override
    public List<Double> visitConstant(SimpleParser.ConstantContext ctx) {
        throw new InterpretationException("Type mismatch: expected sequence but was number", ctx);
    }

    @Override
    public List<Double> visitOpExpression(SimpleParser.OpExpressionContext ctx) {
        throw new InterpretationException("Type mismatch: expected sequence but was number", ctx);
    }
}
