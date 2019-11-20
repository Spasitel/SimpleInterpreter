package com.jetbrains.simpleinterpreter.model.asthandlers;

import com.jetbrains.simpleinterpreter.model.InterpretationException;
import com.jetbrains.simpleinterpreter.model.antlrgen.SimpleLexer;
import com.jetbrains.simpleinterpreter.model.antlrgen.SimpleParser;
import com.jetbrains.simpleinterpreter.model.state.ProgramState;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VoidVisitorTest {

    private VoidVisitor voidVisitor;
    private ProgramState state;

    static ParseTree getParseTree(String program) {
        CharStream codePointCharStream = CharStreams.fromString(program);
        SimpleLexer lex = new SimpleLexer(codePointCharStream); // transforms characters into tokens
        lex.removeErrorListeners();
        CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream
        SimpleParser parser = new SimpleParser(tokens);
        parser.removeErrorListeners();
        ErrorListener listener = new ErrorListener();
        parser.addErrorListener(listener);
        ParseTree parseTree = parser.program();
        assertTrue(listener.getErrors().isEmpty());
        return parseTree;
    }

    @Before
    public void initVisitors() {
        voidVisitor = VoidVisitor.createVisitors();
        state = voidVisitor.getState();
    }

    @Test
    public void printSuccess() {
        ParseTree tree = getParseTree("print \"hello world\"");
        voidVisitor.visit(tree);
        assertTrue(state.getResult().getErrors().isEmpty());
        assertEquals("hello world", state.getResult().getOutput());
    }

    @Test
    public void outSuccess() {
        ParseTree tree = getParseTree("out 5.0");
        voidVisitor.visit(tree);
        assertTrue(state.getResult().getErrors().isEmpty());
        assertEquals("5.0", state.getResult().getOutput());
    }

    @Test(expected = InterpretationException.class)
    public void outFail() {
        ParseTree tree = getParseTree("out {1, 3}");
        voidVisitor.visit(tree);
    }

    @Test
    public void varDoubleSuccess() {
        ParseTree tree = getParseTree("var x = 5.0");
        voidVisitor.visit(tree);
        assertTrue(state.getResult().getErrors().isEmpty());
        assertEquals(Double.compare(5.0, state.getGlobalDoubleVariables().get("x")), 0);
        assertTrue(state.getGlobalSequenceVariables().isEmpty());
        assertTrue(state.getLambdaParameters().isEmpty());
    }

    @Test
    public void varSequenceSuccess() {
        ParseTree tree = getParseTree("var x12y = {1, 5}");
        voidVisitor.visit(tree);
        assertTrue(state.getResult().getErrors().isEmpty());
        assertEquals(5, state.getGlobalSequenceVariables().get("x12y").size());
        assertTrue(state.getGlobalDoubleVariables().isEmpty());
        assertTrue(state.getLambdaParameters().isEmpty());
    }

    @Test
    public void varReduceSuccess() {
        ParseTree tree = getParseTree("var x_12 = reduce({1, 5}, 0, x y -> x+y)");
        voidVisitor.visit(tree);
        assertTrue(state.getResult().getErrors().isEmpty());
        assertEquals(Double.compare(15.0, state.getGlobalDoubleVariables().get("x_12")), 0);
        assertEquals(state.getGlobalDoubleVariables().size(), 1);
        assertTrue(state.getGlobalSequenceVariables().isEmpty());
        assertTrue(state.getLambdaParameters().isEmpty());
    }

    @Test
    public void varMapSuccess() {
        ParseTree tree = getParseTree("var seq_ = map({1, 5}, x -> x+3)");
        voidVisitor.visit(tree);
        assertTrue(state.getResult().getErrors().isEmpty());
        assertEquals(5, state.getGlobalSequenceVariables().get("seq_").size());
        assertEquals(state.getGlobalSequenceVariables().size(), 1);
        assertTrue(state.getGlobalDoubleVariables().isEmpty());
        assertTrue(state.getLambdaParameters().isEmpty());
    }

    @Test
    public void deadCodeRemovedSuccess() {
        ParseTree tree = getParseTree("var x = 5.0 var y = {1,3} out 6");
        voidVisitor.interpret(tree);
        assertTrue(state.getResult().getErrors().isEmpty());
        assertTrue(state.getGlobalDoubleVariables().isEmpty());
        assertTrue(state.getGlobalSequenceVariables().isEmpty());
        assertTrue(state.getLambdaParameters().isEmpty());
    }
}