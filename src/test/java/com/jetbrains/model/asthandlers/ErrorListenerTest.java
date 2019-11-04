package com.jetbrains.model.asthandlers;

import com.jetbrains.common.ErrorInfo;
import com.jetbrains.model.antlrgen.SimpleLexer;
import com.jetbrains.model.antlrgen.SimpleParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ErrorListenerTest {
    @Test
    public void unknownCommandFail() {
        testFail("fail out x fail");
    }

    /*
     ************** print tests
     */
    @Test
    public void printSuccess() {
        testNotFail("print \"hello\"");
    }

    @Test
    public void printVarFail() {
        testFail("print x");
    }

    @Test
    public void printConstantFail() {
        testFail("print 6");
    }

    @Test
    public void printSequenceFail() {
        testFail("print {1, 0}");
    }

    /*
     ************** var tests
     */
    @Test
    public void varConstantSuccess() {
        testNotFail("var x = 5");
    }

    @Test
    public void varSequenceSuccess() {
        testNotFail("var x = {5, 6}");
    }

    @Test
    public void varToVarSuccess() {
        testNotFail("var x12x = y");
    }

    @Test
    public void varReduceSuccess() {
        testNotFail("var x12 = reduce({1,3}, 5 , x y -> x+y)");
    }

    @Test
    public void varExpressionSuccess() {
        testNotFail("var xy12 = 3.0-reduce({1,3}, 5 , x y -> x+y)");
    }

    @Test
    public void varMapSuccess() {
        testNotFail("var x1 = map( {1,3} , x->x+1)");
    }

    @Test
    public void varEmptyFail() {
        testFail("var x = ");
    }

    @Test
    public void varNameFail() {
        testFail("var 1x = 5");
    }

    @Test
    public void varSingSequenceFail() {
        testFail("var x = - {1, 3}");
    }

    @Test
    public void varWrongMapFail() {
        testFail("var x = -map( {1,3} , x->x+1) ");
        testFail("var x = -map( {1,3} , x y ->x+1) ");
        testFail("var x = map( , x->x+1) ");
        testFail("var x = map( {1,3} , ->x+1) ");
        testFail("var x = map( {1,3} , x->) ");
    }

    @Test
    public void varWrongReduceFail() {
        testFail("var x12 = reduce({1,3}, 5 , x -> x+y)");
        testFail("var x12 = reduce({1,3}, 5 , x y -> )");
        testFail("var x12 = reduce({1,3},  , x y -> x)");
        testFail("var x12 = reduce(, 5 , x y -> y)");
    }

    /*
     ************** out tests
     */
    @Test
    public void outConstantSuccess() {
        testNotFail("out 5.0");
    }

    @Test
    public void outVarSuccess() {
        testNotFail("out x");
    }

    @Test
    public void outReduceSuccess() {
        testNotFail("out reduce({0,5}, 3, x y -> x^y)");
    }

    @Test
    public void outExpressionSuccess() {
        testNotFail("out reduce({0,5}, 3, x y -> x^y) + 33");
    }

    @Test
    public void outEmptyFail() {
        testFail("out ");
    }


    /*
     ************** utils
     */
    private List<ErrorInfo> getErrors(String program) {
        ErrorListener listener = new ErrorListener();
        CharStream codePointCharStream = CharStreams.fromString(program);
        SimpleLexer lex = new SimpleLexer(codePointCharStream); // transforms characters into tokens
        lex.removeErrorListeners();
        CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream
        SimpleParser parser = new SimpleParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(listener);
        parser.program();
        return listener.getErrors();
    }

    private void testFail(String program) {
        List<ErrorInfo> errors = getErrors(program);
        assertFalse(errors.isEmpty());
    }

    private void testNotFail(String program) {
        List<ErrorInfo> errors = getErrors(program);
        assertTrue(errors.isEmpty());
    }
}