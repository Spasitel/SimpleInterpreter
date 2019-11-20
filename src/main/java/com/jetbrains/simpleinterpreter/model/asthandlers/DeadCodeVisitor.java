package com.jetbrains.simpleinterpreter.model.asthandlers;

import com.jetbrains.simpleinterpreter.model.antlrgen.SimpleBaseVisitor;
import com.jetbrains.simpleinterpreter.model.antlrgen.SimpleParser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Visitor detects unused variables. Calculation of their values can be skipped during interpretation.
 */
public class DeadCodeVisitor extends SimpleBaseVisitor<Void> {
    private Set<String> usedVars = new LinkedHashSet<>();
    private Set<SimpleParser.VarStmtContext> deadCode = new LinkedHashSet<>();

    Set<SimpleParser.VarStmtContext> getDeadCode() {
        return deadCode;
    }

    @Override
    public Void visitProgram(SimpleParser.ProgramContext ctx) {
        LinkedList<ParseTree> reversStmts = new LinkedList<>();
        for (ParseTree tree : ctx.children)
            if (tree instanceof SimpleParser.StmtContext)
                reversStmts.addFirst(tree);

        for (ParseTree tree : reversStmts) {
            if (Thread.currentThread().isInterrupted())
                throw new RuntimeException("Interrupted");
            visit(tree);
        }
        return null;
    }

    @Override
    public Void visitVarStmt(SimpleParser.VarStmtContext ctx) {
        String name = ctx.to.getText();
        if (usedVars.contains(name))
            visit(ctx.from);
        else
            deadCode.add(ctx);
        return null;
    }

    @Override
    public Void visitVariable(SimpleParser.VariableContext ctx) {
        usedVars.add(ctx.getText());
        return null;
    }

    @Override
    public Void visitOutStmt(SimpleParser.OutStmtContext ctx) {
        visit(ctx.arg);
        return null;
    }

    @Override
    public Void visitOpExpression(SimpleParser.OpExpressionContext ctx) {
        visit(ctx.left);
        visit(ctx.right);
        return null;
    }

    @Override
    public Void visitParentheses(SimpleParser.ParenthesesContext ctx) {
        visit(ctx.arg);
        return null;
    }

    @Override
    public Void visitSequenceDef(SimpleParser.SequenceDefContext ctx) {
        visit(ctx.start);
        visit(ctx.end);
        return null;
    }

    @Override
    public Void visitMap(SimpleParser.MapContext ctx) {
        visit(ctx.arg);
        visit(ctx.lambda);
        return null;
    }

    @Override
    public Void visitReduce(SimpleParser.ReduceContext ctx) {
        visit(ctx.arg);
        visit(ctx.start);
        visit(ctx.lambda);
        return null;
    }
}
