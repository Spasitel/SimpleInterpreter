package com.jetbrains.simpleinterpreter.model.asthandlers;

import com.jetbrains.simpleinterpreter.model.InterpretationException;
import com.jetbrains.simpleinterpreter.model.state.ProgramState;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @implNote All tests use command "var" and parsing start point "program" instead of
 * start point "expr" because "expr" doesn't have EOF closing rule.
 * For example <br> "<b><code>5 fail</code></b>" is valid expr "<b><code>5</code></b>" but <br>
 * "<b><code>var x = 5 fail</code></b>" is invalid program.
 */
public class SequenceVisitorTest {
    private VoidVisitor voidVisitor;
    private ProgramState state;

    @Before
    public void initVisitors() {
        state = new ProgramState();
        voidVisitor = VoidVisitor.createVisitors(state);
    }

    @Test
    public void sequenceDefSuccess() {
        ParseTree tree = VoidVisitorTest.getParseTree("var x = {-1, 5}");
        voidVisitor.visit(tree);
        assertTrue(state.getResult().getErrors().isEmpty());
        testSequenceInGlobalVars(7);
    }

    @Test
    public void sequenceDefOpSuccess() {
        ParseTree tree = VoidVisitorTest.getParseTree("var x = {10 - 9 , 9^0.5}");
        voidVisitor.visit(tree);
        assertTrue(state.getResult().getErrors().isEmpty());
        testSequenceInGlobalVars(3);
    }

    @Test(expected = InterpretationException.class)
    public void sequenceDefRealFail() {
        ParseTree tree = VoidVisitorTest.getParseTree("var x = {0 , 1.99}");
        voidVisitor.visit(tree);
    }

    @Test(expected = InterpretationException.class)
    public void sequenceDefStartGtEndFail() {
        ParseTree tree = VoidVisitorTest.getParseTree("var x = {10 , 8}");
        voidVisitor.visit(tree);
    }

    @Test(expected = InterpretationException.class)
    public void sequenceDefSeqArgFail() {
        ParseTree tree = VoidVisitorTest.getParseTree("var x = {{1,2} , 8}");
        voidVisitor.visit(tree);
    }

    @Test
    public void mapSuccess() {
        ParseTree tree = VoidVisitorTest.getParseTree("var x = map({1 , 5}, n -> n-1)");
        voidVisitor.visit(tree);
        assertTrue(state.getResult().getErrors().isEmpty());
        testSequenceInGlobalVars(5);
    }

    @Test(expected = InterpretationException.class)
    public void mapArgFail() {
        ParseTree tree = VoidVisitorTest.getParseTree("var x = map( 5, n->n)");
        voidVisitor.visit(tree);
    }

    @Test(expected = InterpretationException.class)
    public void mapLambdaSequenceFail() {
        ParseTree tree = VoidVisitorTest.getParseTree("var x = map( {-10,5}, n->{1,n})");
        voidVisitor.visit(tree);
    }

    @Test(expected = InterpretationException.class)
    public void mapLambdaUnknownVarFail() {
        ParseTree tree = VoidVisitorTest.getParseTree("var x = map( {5, 10} , n-> z +2)");
        voidVisitor.visit(tree);
    }

    private void testSequenceInGlobalVars(int size) {
        assertTrue(state.getGlobalDoubleVariables().isEmpty());
        assertTrue(state.getLambdaParameters().isEmpty());
        assertEquals(1, state.getGlobalSequenceVariables().size());
        assertEquals(size, state.getGlobalSequenceVariables().get("x").size());
    }
}