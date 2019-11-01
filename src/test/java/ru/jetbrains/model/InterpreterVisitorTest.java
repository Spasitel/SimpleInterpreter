package ru.jetbrains.model;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import ru.jetbrains.model.antlrGen.SimpleLexer;
import ru.jetbrains.model.antlrGen.SimpleParser;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class InterpreterVisitorTest {
  /*  @Test
    public void constantTest() {
        SimpleParser parser = getSimpleParser(CharStreams.fromString("500.12"));
        ParseTree tree = parser.constant();

        ProgramState programState = new ProgramState();
        programState.setReturnType(new ReturnType(DataType.NUMERICAL, null, null));
        InterpreterVisitor interpreterVisitor = new InterpreterVisitor(programState);
        Data data = interpreterVisitor.visit(tree);
        assertEquals(data.getType(), DataType.NUMERICAL);
        assertEquals(0, Double.compare(((Numerical) data).getValue(), 500.12));
    }

    @Test
    public void numericalSignTest() {
        SimpleParser parser = getSimpleParser(CharStreams.fromString("-500.12 + -5 + (2 + 3)"));
        ParseTree tree = parser.numerical();

        ProgramState programState = new ProgramState();
        programState.setReturnType(new ReturnType(DataType.NUMERICAL, null, null));
        InterpreterVisitor interpreterVisitor = new InterpreterVisitor(programState);
        Data data = interpreterVisitor.visit(tree);
        assertEquals(data.getType(), DataType.NUMERICAL);
        assertEquals(0, Double.compare(((Numerical) data).getValue(), -500.12));
    }*/


    private SimpleParser getSimpleParser(CharStream codePointCharStream) {
        CharStream input = codePointCharStream;
        SimpleLexer lex = new SimpleLexer(input); // transforms characters into tokens
        CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream
        return new SimpleParser(tokens);
    }

    @Test
    public void exampleTest() throws IOException {
        //TODO: fix or remove
        String fileName = "grammarTest.txt";
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);
        SimpleParser parser = getSimpleParser(CharStreams.fromStream(is));
        ParseTree t = parser.program();
        System.out.println(t.getText());
    }
}