package ru.jetbrains.model;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;
import ru.jetbrains.common.ErrorInfo;
import ru.jetbrains.model.antlrGen.SimpleLexer;
import ru.jetbrains.model.antlrGen.SimpleParser;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ErrorListenerTest {
    @Test
    public void testPrintFail() {
        testFail("fail out x fail");
    }

    @Test
    public void testVarFail() {
        testFail("var x = ");
    }

    @Test
    public void testPrint() {
        testNotFail("print \"hello\"");
    }


    private void testFail(String program) {
        List<ErrorInfo> errors = getErrors(program);
        assertFalse(errors.isEmpty());
    }

    private void testNotFail(String program) {
        List<ErrorInfo> errors = getErrors(program);
        assertTrue(errors.isEmpty());
    }

    private List<ErrorInfo> getErrors(String program) {
        CharStream codePointCharStream = CharStreams.fromString(program);
        SimpleLexer lex = new SimpleLexer(codePointCharStream); // transforms characters into tokens
        lex.removeErrorListeners();
        CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream
        SimpleParser parser = new SimpleParser(tokens);
        parser.removeErrorListeners();
        ErrorListener listener = new ErrorListener();
        parser.addErrorListener(listener);
        parser.program();
        return listener.getErrors();
    }
}