package ru.jetbrains.model;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import ru.jetbrains.model.antlrGen.SimpleLexer;
import ru.jetbrains.model.antlrGen.SimpleParser;
import ru.jetbrains.model.data.Data;
import ru.jetbrains.model.data.DataType;
import ru.jetbrains.model.data.Numerical;
import ru.jetbrains.model.state.ProgramState;
import ru.jetbrains.model.state.ReturnType;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InterpreterVisitorTest {
    @Test
    public void constantTest() {
        CharStream input = CharStreams.fromString("500.12");
        SimpleLexer lex = new SimpleLexer(input); // transforms characters into tokens
        CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream
        SimpleParser parser = new SimpleParser(tokens); // transforms tokens into parse trees
        ParseTree tree =  parser.constant();

        ProgramState programState = new ProgramState();
        programState.setReturnType(new ReturnType(null, null, DataType.NUMERICAL));
        InterpreterVisitor interpreterVisitor = new InterpreterVisitor(programState);
        Data data = interpreterVisitor.visit(tree);
        assertEquals(data.getType(), DataType.NUMERICAL);
        assertEquals(0, Double.compare(((Numerical) data).getValue(), 500.12));
    }

    @Test
    public void exampleTest() throws IOException {
        //TODO: fix or remove
        String fileName = "grammarTest.txt";
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);
        CharStream input = CharStreams.fromStream(is);
        SimpleLexer lex = new SimpleLexer(input); // transforms characters into tokens
        CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream
        SimpleParser parser = new SimpleParser(tokens); // transforms tokens into parse trees
        ParseTree t = parser.program();
        System.out.println(t.getText());
    }
}