package com.jetbrains.model;

import com.jetbrains.common.ErrorInfo;
import com.jetbrains.model.antlrGen.SimpleParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;
import com.jetbrains.model.antlrGen.SimpleLexer;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ErrorListenerTest {
    @Test
    public void unknownCommandFail() {
        new ProgramSyntaxTester().testFail("fail out x fail");
    }

    /*
     ************** print tests
     */
    @Test
    public void printSuccess() {
        new ProgramSyntaxTester().testNotFail("print \"hello\"");
    }

    @Test
    public void printVarFail() {
        new ProgramSyntaxTester().testFail("print x");
    }

    @Test
    public void printConstantFail() {
        new ProgramSyntaxTester().testFail("print 6");
    }

    @Test
    public void printSequenceFail() {
        new ProgramSyntaxTester().testFail("print {1, 0}");
    }

    /*
     ************** var tests
     */
    @Test
    public void varConstantSuccess() {
        new ProgramSyntaxTester().testNotFail("var x = 5");
    }

    @Test
    public void varSequenceSuccess() {
        new ProgramSyntaxTester().testNotFail("var x = {5, 6}");
    }

    @Test
    public void varToVarSuccess() {
        new ProgramSyntaxTester().testNotFail("var x12x = y");
    }

    @Test
    public void varReduceSuccess() {
        new ProgramSyntaxTester().testNotFail("var x12 = reduce({1,3}, 5 , x y -> x+y)");
    }

    @Test
    public void varSignReduceSuccess() {
        new ProgramSyntaxTester().testFail("var xy12 = -reduce({1,3}, 5 , x y -> x+y)");
    }

    @Test
    public void varMapSuccess() {
        new ProgramSyntaxTester().testNotFail("var x1 = map( {1,3} , x->x+1)");
    }

    @Test
    public void varEmptyFail() {
        new ProgramSyntaxTester().testFail("var x = ");
    }

    @Test
    public void varNameFail() {
        new ProgramSyntaxTester().testFail("var 1x = 5");
    }

    @Test
    public void varSingSequenceFail() {
        new ProgramSyntaxTester().testFail("var x = - {1, 3}");
    }

    @Test
    public void varSingMapFail() {
        new ProgramSyntaxTester().testFail("var x = -map( {1,3} , x->x+1) ");
    }

    /*
     ************** out tests
     */
    @Test
    public void outConstantSuccess() {
        new ProgramSyntaxTester().testNotFail("out 5.0");
    }

    @Test
    public void outVarSuccess() {
        new ProgramSyntaxTester().testNotFail("out x");
    }

    @Test
    public void outReduceSuccess() {
        new ProgramSyntaxTester().testNotFail("out reduce({0,5}, 3, x y -> x^y)");
    }


    /*
     ************** utils
     */
    private static class ProgramSyntaxTester extends SyntaxErrorTester {
        @Override
        void runParser(SimpleParser parser) {
            parser.program();
        }
    }

    private static abstract class SyntaxErrorTester {
        abstract void runParser(SimpleParser parser);

        private SimpleParser getSimpleParser(String program, ErrorListener listener) {
            CharStream codePointCharStream = CharStreams.fromString(program);
            SimpleLexer lex = new SimpleLexer(codePointCharStream); // transforms characters into tokens
            lex.removeErrorListeners();
            CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream
            SimpleParser parser = new SimpleParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(listener);
            return parser;
        }

        private List<ErrorInfo> getErrors(String program) {
            ErrorListener listener = new ErrorListener();
            SimpleParser parser = getSimpleParser(program, listener);
            runParser(parser);
            return listener.getErrors();
        }

        void testFail(String program) {
            List<ErrorInfo> errors = getErrors(program);
            assertFalse(errors.isEmpty());
        }

        void testNotFail(String program) {
            List<ErrorInfo> errors = getErrors(program);
            assertTrue(errors.isEmpty());
        }
    }
}