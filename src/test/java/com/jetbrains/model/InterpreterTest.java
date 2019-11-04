package com.jetbrains.model;

import com.jetbrains.model.antlrGen.SimpleParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import com.jetbrains.model.antlrGen.SimpleLexer;
import com.jetbrains.model.state.ProgramState;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class InterpreterTest {
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
    }*/

    @Test
    public void numericalSignTest() {
        SimpleParser parser = getSimpleParser(CharStreams.fromString("out reduce( ({1,2}), 1 , x y -> reduce({1,x} , 4 , m n -> x+n))"));
        ParseTree t = parser.program();
        ProgramState state = new ProgramState();
        t.accept(new VoidVisitor(state));
        System.out.println(state.getResult().getOutput());
    }


    private SimpleParser getSimpleParser(CharStream codePointCharStream) {
        SimpleLexer lex = new SimpleLexer(codePointCharStream); // transforms characters into tokens
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
        ProgramState state = new ProgramState();
        t.accept(new VoidVisitor(state));
        System.out.println(state.getResult().getOutput());
    }
}