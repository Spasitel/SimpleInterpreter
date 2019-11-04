package com.jetbrains.model;

import com.jetbrains.model.antlrGen.SimpleBaseVisitor;
import com.jetbrains.model.antlrGen.SimpleParser;
import com.jetbrains.model.state.ProgramState;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class SequenceVisitor extends SimpleBaseVisitor<List<Double>> {
    private ProgramState state;

    public SequenceVisitor(ProgramState state) {
        this.state = state;
    }

    @Override
    public List<Double> visitSequenceDef(SimpleParser.SequenceDefContext ctx) {
        int start = getIntValue(ctx.start);
        int end = getIntValue(ctx.end);

        if (start > end)
            throw new InterpreterException("Wrong sequence: {" + start + " ," + end + "}", ctx);
        List<Double> result = new ArrayList<>();
        for (int i = start; i <= end; i++)
            result.add((double) i);
        return result;
    }

    private int getIntValue(SimpleParser.ExprContext start) {
        double value = new DoubleVisitor(state).visit(start);
        if ((value == Math.floor(value)) && !Double.isInfinite(value)) {
            return (int) value;
        }
        throw new InterpreterException("Expected integer but was: " + value, start);
    }

    @Override
    public List<Double> visitVariable(SimpleParser.VariableContext ctx) {
        TerminalNode identifier = ctx.IDENTIFIER();
        new DoubleVisitor(state).commonVariableUseCheck(identifier);

        String name = identifier.getText();
        if (state.getGlobalSequenceVariables().containsKey(name))
            return state.getGlobalSequenceVariables().get(name);

        throw new InterpreterException("Type mismatch: expected sequence but was number", identifier.getSymbol());
    }

    @Override
    public List<Double> visitMap(SimpleParser.MapContext ctx) {
        Token param = ctx.param;
        new VoidVisitor(state).commonNewVariableCheck(param);

        List<Double> argument = visit(ctx.arg);
        List<Double> result = new ArrayList<>();
        DoubleVisitor doubleVisitor = new DoubleVisitor(state);
        for (double element : argument) {
            state.getLambdaParameters().put(param.getText(), element);
            result.add(doubleVisitor.visit(ctx.lambda));
        }
        state.getLambdaParameters().remove(param.getText());
        return result;
    }
}
