package com.jetbrains.simpleinterpreter.model.asthandlers;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DeadCodeVisitorTest {
    private DeadCodeVisitor deadCodeVisitor;

    @Before
    public void initVisitor() {
        deadCodeVisitor = new DeadCodeVisitor();
    }

    @Test
    public void useInOutSuccess() {
        ParseTree tree = VoidVisitorTest.getParseTree("var x = 5 out 2*(x+3)");
        deadCodeVisitor.visit(tree);
        assertTrue(deadCodeVisitor.getDeadCode().isEmpty());
    }

    @Test
    public void notUseInOutFail() {
        ParseTree tree = VoidVisitorTest.getParseTree("var x = 5 out 3");
        deadCodeVisitor.visit(tree);
        assertFalse(deadCodeVisitor.getDeadCode().isEmpty());
    }

    @Test
    public void notOutFail() {
        ParseTree tree = VoidVisitorTest.getParseTree("var x = 5");
        deadCodeVisitor.visit(tree);
        assertFalse(deadCodeVisitor.getDeadCode().isEmpty());
    }

    @Test
    public void printFail() {
        ParseTree tree = VoidVisitorTest.getParseTree("var x = 5 print \"x\"");
        deadCodeVisitor.visit(tree);
        assertFalse(deadCodeVisitor.getDeadCode().isEmpty());
    }

    @Test
    public void useInVarSuccess() {
        ParseTree tree = VoidVisitorTest.getParseTree("var x = {1, 5} var y = map( x, n-> n+0.5) out reduce(y, 0, n m ->n +m)");
        deadCodeVisitor.visit(tree);
        assertTrue(deadCodeVisitor.getDeadCode().isEmpty());
    }

    @Test
    public void useInVarFail() {
        ParseTree tree = VoidVisitorTest.getParseTree("var x = {1, 5} var y = map( x, n-> n+0.5) out 3");
        deadCodeVisitor.visit(tree);
        assertFalse(deadCodeVisitor.getDeadCode().isEmpty());
    }



}