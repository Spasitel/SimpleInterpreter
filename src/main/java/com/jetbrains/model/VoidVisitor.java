package com.jetbrains.model;

import com.jetbrains.model.antlrGen.SimpleBaseVisitor;
import com.jetbrains.model.antlrGen.SimpleParser;
import com.jetbrains.model.state.ProgramState;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;
import java.util.Map;

public class VoidVisitor extends SimpleBaseVisitor<Void> {
    private ProgramState state;

    public VoidVisitor(ProgramState state) {
        this.state = state;
    }

    @Override
    public Void visitProgram(SimpleParser.ProgramContext ctx) {
        for (ParseTree tree : ctx.children) {
            if (tree instanceof SimpleParser.StmtContext)
                visit(tree);
        }
        return null;
    }

    @Override
    public Void visitOutStmt(SimpleParser.OutStmtContext ctx) {
        Double value = new DoubleVisitor(state).visit(ctx.arg);
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
            double value = new DoubleVisitor(state).visit(from);
            globalDoubleVariables.put(varName, value);

        } else if (from instanceof SimpleParser.SequenceDefContext ||
                from instanceof SimpleParser.MapContext) {
            List<Double> sequence = new SequenceVisitor(state).visit(from);
            globalSequenceVariables.put(varName, sequence);

        } else if (from instanceof SimpleParser.VariableContext) {
            Token fromVar = ((SimpleParser.VariableContext) from).IDENTIFIER().getSymbol();
            String fromVarName = fromVar.getText();
            if (globalDoubleVariables.containsKey(fromVarName)) {
                globalDoubleVariables.put(varName, globalDoubleVariables.get(fromVarName));
            } else if (globalSequenceVariables.containsKey(fromVarName)) {
                globalSequenceVariables.put(varName, globalSequenceVariables.get(fromVarName));
            } else {
                throw new InterpreterException("Variable " + fromVarName + " not found", fromVar);
            }

        } else {
            throw new InterpreterException("Unknown operation", from);
        }
        return null;
    }

    void commonNewVariableCheck(Token node) {
        String varName = node.getText();
        if (state.getGlobalDoubleVariables().containsKey(varName) ||
                state.getGlobalSequenceVariables().containsKey(varName) ||
                state.getLambdaParameters().containsKey(varName)) {
            throw new InterpreterException("Variable " + varName + " already exist", node);
        }
    }
}
