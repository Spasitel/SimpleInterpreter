package com.jetbrains.simpleinterpreter.model.asthandlers;

import com.jetbrains.simpleinterpreter.model.InterpretationException;
import com.jetbrains.simpleinterpreter.model.antlrgen.SimpleBaseVisitor;
import com.jetbrains.simpleinterpreter.model.antlrgen.SimpleParser;
import com.jetbrains.simpleinterpreter.model.state.ProgramState;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Visitor for AST nodes which returns sequence value
 */
public class SequenceVisitor extends SimpleBaseVisitor<Sequence> {
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
    public Sequence visitSequenceDef(SimpleParser.SequenceDefContext ctx) {
        long start = getIntValue(ctx.start);
        long end = getIntValue(ctx.end);

        if (start > end)
            throw new InterpretationException("Wrong sequence: {" + start + " ," + end + "}", ctx);
        if (end - start >= Integer.MAX_VALUE)
            throw new InterpretationException(
                    "Sequence is too large: {" + start + " ," + end + "}, size: " + (end - start + 1), ctx);

        Sequence result = new Sequence(start, end);

        logger.trace("{} := sequence size:{} first:{} last:{}", ctx.getText(), result.size(), result.getFirst(),
                result.getLast());
        return result;
    }

    private long getIntValue(SimpleParser.ExprContext start) {
        double value = doubleVisitor.visitDouble(start);
        if ((value == Math.floor(value)) && !Double.isInfinite(value)) {
            return (long) value;
        }
        throw new InterpretationException("Expected integer but was: " + value, start);
    }

    @Override
    public Sequence visitVariable(SimpleParser.VariableContext ctx) {
        TerminalNode identifier = ctx.IDENTIFIER();
        voidVisitor.commonVariableUseCheck(identifier);

        String name = identifier.getText();
        if (state.getGlobalSequenceVariables().containsKey(name)) {
            Sequence result = state.getGlobalSequenceVariables().get(name);
            logger.trace("{} := sequence size:{} first:{} last:{}", ctx.getText(), result.size(), result.getFirst(),
                    result.getLast());
            return result;
        }

        throw new InterpretationException("Type mismatch: expected sequence but was number", identifier.getSymbol());
    }

    @Override
    public Sequence visitMap(SimpleParser.MapContext ctx) {
        Token param = ctx.param;
        voidVisitor.commonNewVariableCheck(param);

        Sequence argument = visit(ctx.arg);
        double[] result = new double[argument.size()];
        int i = 0;
        for (double element : argument) {
            state.getLambdaParameters().put(param.getText(), element);
            result[i++] = doubleVisitor.visitDouble(ctx.lambda);
            if (Thread.currentThread().isInterrupted())
                throw new RuntimeException("Interrupted");
        }
        state.getLambdaParameters().remove(param.getText());
        Sequence resultSequence = new Sequence(result);
        logger.trace("{} := sequence size:{} first:{} last:{}", ctx.getText(), resultSequence.size(),
                resultSequence.getFirst(), resultSequence.getLast());
        return resultSequence;
    }

    @Override
    public Sequence visitParentheses(SimpleParser.ParenthesesContext ctx) {
        throw new InterpretationException("Type mismatch: expected sequence but was number", ctx);
    }

    @Override
    public Sequence visitReduce(SimpleParser.ReduceContext ctx) {
        throw new InterpretationException("Type mismatch: expected sequence but was number", ctx);
    }

    @Override
    public Sequence visitConstant(SimpleParser.ConstantContext ctx) {
        throw new InterpretationException("Type mismatch: expected sequence but was number", ctx);
    }

    @Override
    public Sequence visitOpExpression(SimpleParser.OpExpressionContext ctx) {
        throw new InterpretationException("Type mismatch: expected sequence but was number", ctx);
    }
}
