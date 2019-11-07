package com.jetbrains.model.asthandlers;

import com.jetbrains.model.InterpretationException;
import com.jetbrains.model.antlrgen.SimpleBaseVisitor;
import com.jetbrains.model.antlrgen.SimpleParser;
import com.jetbrains.model.state.ProgramState;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;
import java.util.Map;

public class VoidVisitor extends SimpleBaseVisitor<Void> {
    private ProgramState state;
    private DoubleVisitor doubleVisitor;
    private SequenceVisitor sequenceVisitor;

    private VoidVisitor(ProgramState state) {
        this.state = state;
    }

    public static VoidVisitor createVisitors(ProgramState programState) {
        VoidVisitor voidVisitor = new VoidVisitor(programState);
        DoubleVisitor doubleVisitor = new DoubleVisitor(programState);
        SequenceVisitor sequenceVisitor = new SequenceVisitor(programState);

        voidVisitor.setDoubleVisitor(doubleVisitor);
        voidVisitor.setSequenceVisitor(sequenceVisitor);

        doubleVisitor.setVoidVisitor(voidVisitor);
        doubleVisitor.setSequenceVisitor(sequenceVisitor);

        sequenceVisitor.setVoidVisitor(voidVisitor);
        sequenceVisitor.setDoubleVisitor(doubleVisitor);

        return voidVisitor;
    }

    private void setDoubleVisitor(DoubleVisitor doubleVisitor) {
        this.doubleVisitor = doubleVisitor;
    }

    private void setSequenceVisitor(SequenceVisitor sequenceVisitor) {
        this.sequenceVisitor = sequenceVisitor;
    }

    @Override
    public Void visitProgram(SimpleParser.ProgramContext ctx) {
        for (ParseTree tree : ctx.children) {
            if (tree instanceof SimpleParser.StmtContext)
                visit(tree);
            if (Thread.currentThread().isInterrupted())
                throw new RuntimeException("Interrupted");
        }
        return null;
    }

    @Override
    public Void visitOutStmt(SimpleParser.OutStmtContext ctx) {
        Double value = doubleVisitor.visit(ctx.arg);
        state.getResult().addToOutput(value.toString());
        return null;
    }

    @Override
    public Void visitPrintStmt(SimpleParser.PrintStmtContext ctx) {
        String str = ctx.STRING().getSymbol().getText();
        state.getResult().addToOutput(str.substring(1, str.length() - 1));
        return null;
    }

    @Override
    public Void visitVarStmt(SimpleParser.VarStmtContext ctx) {
        commonNewVariableCheck(ctx.IDENTIFIER().getSymbol());

        String varName = ctx.IDENTIFIER().getText();
        Map<String, List<Double>> globalSequenceVariables = state.getGlobalSequenceVariables();
        Map<String, Double> globalDoubleVariables = state.getGlobalDoubleVariables();

        SimpleParser.ExprContext from = ctx.from;
        if (from instanceof SimpleParser.OpExpressionContext ||
                from instanceof SimpleParser.ParenthesesContext ||
                from instanceof SimpleParser.ConstantContext ||
                from instanceof SimpleParser.ReduceContext) {
            double value = doubleVisitor.visit(from);
            globalDoubleVariables.put(varName, value);

        } else if (from instanceof SimpleParser.SequenceDefContext ||
                from instanceof SimpleParser.MapContext) {
            List<Double> sequence = sequenceVisitor.visit(from);
            globalSequenceVariables.put(varName, sequence);

        } else if (from instanceof SimpleParser.VariableContext) {
            Token fromVar = ((SimpleParser.VariableContext) from).IDENTIFIER().getSymbol();
            String fromVarName = fromVar.getText();
            if (globalDoubleVariables.containsKey(fromVarName)) {
                globalDoubleVariables.put(varName, globalDoubleVariables.get(fromVarName));
            } else if (globalSequenceVariables.containsKey(fromVarName)) {
                globalSequenceVariables.put(varName, globalSequenceVariables.get(fromVarName));
            } else {
                throw new InterpretationException("Variable " + fromVarName + " not found", fromVar);
            }

        } else {
            throw new InterpretationException("Unknown operation", from);
        }
        return null;
    }

    void commonNewVariableCheck(Token node) {
        String varName = node.getText();
        if (state.getGlobalDoubleVariables().containsKey(varName) ||
                state.getGlobalSequenceVariables().containsKey(varName) ||
                state.getLambdaParameters().containsKey(varName)) {
            throw new InterpretationException("Variable " + varName + " already exist", node);
        }
    }
}
