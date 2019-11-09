package com.jetbrains.simpleinterpreter.model.asthandlers;

import com.jetbrains.simpleinterpreter.model.InterpretationException;
import com.jetbrains.simpleinterpreter.model.antlrgen.SimpleBaseVisitor;
import com.jetbrains.simpleinterpreter.model.antlrgen.SimpleParser;
import com.jetbrains.simpleinterpreter.model.state.ProgramState;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Visitor for AST nodes which returns no value. <br>
 * <br>
 * This is main visitor because the AST root <b>program</b> returns no value an should be visited by this class.
 */
public class VoidVisitor extends SimpleBaseVisitor<Void> {
    private final Logger logger = LoggerFactory.getLogger(VoidVisitor.class);

    private ProgramState state;
    private DoubleVisitor doubleVisitor;
    private SequenceVisitor sequenceVisitor;

    private VoidVisitor(ProgramState state) {
        this.state = state;
    }

    /**
     * Create visitors for interpretation
     * @param programState shared mutable state. Result of interpretation is stored here
     * @return main visitor
     */
    public static VoidVisitor createVisitors(ProgramState programState) {
        VoidVisitor voidVisitor = new VoidVisitor(programState);
        DoubleVisitorImpl doubleVisitor = new DoubleVisitorImpl(programState);
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
        double value = doubleVisitor.visitDouble(ctx.arg);
        String str = Double.toString(value);
        state.getResult().addToOutput(str);
        logger.trace("out: " + str);
        return null;
    }

    @Override
    public Void visitPrintStmt(SimpleParser.PrintStmtContext ctx) {
        String str = ctx.STRING().getSymbol().getText();
        String output = str.substring(1, str.length() - 1);
        state.getResult().addToOutput(output);
        logger.trace("print " + output);
        return null;
    }

    @Override
    public Void visitVarStmt(SimpleParser.VarStmtContext ctx) {
        commonNewVariableCheck(ctx.IDENTIFIER().getSymbol());

        String varName = ctx.IDENTIFIER().getText();
        Map<String, Sequence> globalSequenceVariables = state.getGlobalSequenceVariables();
        Map<String, Double> globalDoubleVariables = state.getGlobalDoubleVariables();

        SimpleParser.ExprContext from = ctx.from;
        if (from instanceof SimpleParser.OpExpressionContext ||
                from instanceof SimpleParser.ParenthesesContext ||
                from instanceof SimpleParser.ConstantContext ||
                from instanceof SimpleParser.ReduceContext) {
            double value = doubleVisitor.visitDouble(from);
            logger.trace("var {} = {}", varName, value);
            globalDoubleVariables.put(varName, value);

        } else if (from instanceof SimpleParser.SequenceDefContext ||
                from instanceof SimpleParser.MapContext) {
            Sequence sequence = sequenceVisitor.visit(from);
            globalSequenceVariables.put(varName, sequence);
            logger.trace("var {} = sequence size {}", varName, sequence.size());
        } else if (from instanceof SimpleParser.VariableContext) {
            Token fromVar = ((SimpleParser.VariableContext) from).IDENTIFIER().getSymbol();
            String fromVarName = fromVar.getText();
            if (globalDoubleVariables.containsKey(fromVarName)) {
                Double value = globalDoubleVariables.get(fromVarName);
                globalDoubleVariables.put(varName, value);
                logger.trace("var {} = {}", varName, value);
            } else if (globalSequenceVariables.containsKey(fromVarName)) {
                Sequence sequence = globalSequenceVariables.get(fromVarName);
                globalSequenceVariables.put(varName, sequence);
                logger.trace("var {} = sequence size {}", varName, sequence.size());
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

    void commonVariableUseCheck(TerminalNode identifier) {
        String name = identifier.getText();
        boolean isGlobal = state.getGlobalDoubleVariables().containsKey(name) ||
                state.getGlobalSequenceVariables().containsKey(name);
        if (!isGlobal && !state.getLambdaParameters().containsKey(name))
            throw new InterpretationException("Variable " + name + " not found", identifier.getSymbol());

        if (!state.getLambdaParameters().isEmpty() && isGlobal)
            throw new InterpretationException("Access to global variable from lambda", identifier.getSymbol());
    }
}
