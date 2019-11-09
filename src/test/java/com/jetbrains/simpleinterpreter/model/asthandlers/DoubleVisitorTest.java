package com.jetbrains.simpleinterpreter.model.asthandlers;

import com.jetbrains.simpleinterpreter.model.InterpretationException;
import com.jetbrains.simpleinterpreter.model.state.ProgramState;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @implNote All tests use command "out" and parsing start point "program" instead of
 * start point "expr" because "expr" doesn't have EOF closing rule.
 * For example <br> "<b><code>5 fail</code></b>" is valid expr "<b><code>5</code></b>" but <br>
 * "<b><code>out 5 fail</code></b>" is invalid program.
 */
public class DoubleVisitorTest {
    private VoidVisitor voidVisitor;
    private ProgramState state;

    @Before
    public void initVisitors() {
        state = new ProgramState();
        voidVisitor = VoidVisitor.createVisitors(state);
    }

    @Test
    public void opSuccess() {
        ParseTree tree = VoidVisitorTest.getParseTree("out 3.0 + 5.0* -2 + 2^3^2 / 8 - 5* (1--2)");
        voidVisitor.visit(tree);
        assertTrue(state.getResult().getErrors().isEmpty());
        assertEquals("42.0", state.getResult().getOutput());
    }

    @Test(expected = InterpretationException.class)
    public void opSequenceFail() {
        ParseTree tree = VoidVisitorTest.getParseTree("out 3.0 + {1, 4}");
        voidVisitor.visit(tree);
    }

    @Test
    public void reduceSuccess() {
        ParseTree tree = VoidVisitorTest.getParseTree("out reduce({1, 5}, 1, x y -> x*y)");
        voidVisitor.visit(tree);
        assertTrue(state.getResult().getErrors().isEmpty());
        assertEquals("120.0", state.getResult().getOutput());
    }

    @Test(expected = InterpretationException.class)
    public void reduceFirstArgFail() {
        ParseTree tree = VoidVisitorTest.getParseTree("out reduce( 10 , 1, x y -> x*y)");
        voidVisitor.visit(tree);
    }

    @Test(expected = InterpretationException.class)
    public void reduceSecondArgFail() {
        ParseTree tree = VoidVisitorTest.getParseTree("out reduce( {10, 12} , {1, 5}, x y -> x*y)");
        voidVisitor.visit(tree);
    }

    @Test(expected = InterpretationException.class)
    public void reduceLambdaSequenceFail() {
        ParseTree tree = VoidVisitorTest.getParseTree("out reduce( {10, 12} , 2, x y -> {x, y})");
        voidVisitor.visit(tree);
    }

    @Test(expected = InterpretationException.class)
    public void reduceLambdaMapFail() {
        ParseTree tree = VoidVisitorTest.getParseTree("out reduce( {10, 12} , 2, x y -> map({x,y}, n -> n +1))");
        voidVisitor.visit(tree);
    }

    @Test(expected = InterpretationException.class)
    public void reduceSameLambdaParamsFail() {
        ParseTree tree = VoidVisitorTest.getParseTree("out reduce( {10, 12} , 1, x x -> 5)");
        voidVisitor.visit(tree);
    }

    @Test(expected = InterpretationException.class)
    public void reduceWrongUseLambdaParamFail() {
        ParseTree tree = VoidVisitorTest.getParseTree("out reduce( {10, 12} , 3, x y -> reduce(x, 0, n m -> n+m))");
        voidVisitor.visit(tree);
    }
}