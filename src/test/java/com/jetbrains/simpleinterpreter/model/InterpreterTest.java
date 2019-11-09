package com.jetbrains.simpleinterpreter.model;

import com.jetbrains.simpleinterpreter.common.ProgramResult;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@SuppressWarnings("OptionalGetWithoutIsPresent")
public class InterpreterTest {

    @Test
    public void syntaxErrorFail() {
        ProgramResult result = new Interpreter().process(
                "unknown command").get();
        assertFalse(result.getErrors().isEmpty());
    }

    @Test
    public void globalVarDoubleSuccess() {
        ProgramResult result = new Interpreter().process(
                "var x = 5.0 " +
                        "out x").get();
        assertTrue(result.getErrors().isEmpty());
        assertEquals(result.getOutput(), "5.0");
    }

    @Test
    public void globalVarSequenceSuccess() {
        ProgramResult result = new Interpreter().process(
                "var x = {1, 3} " +
                        "out reduce(x , 0 , n m -> n + m)").get();
        assertTrue(result.getErrors().isEmpty());
        assertEquals(result.getOutput(), "6.0");
    }

    @Test
    public void globalVarCopySuccess() {
        ProgramResult result = new Interpreter().process(
                "var x = {1, 3} " +
                        "var y = x " +
                        "out reduce(y , 0 , n m -> n + m)").get();
        assertTrue(result.getErrors().isEmpty());
        assertEquals(result.getOutput(), "6.0");
    }

    @Test
    public void globalVarSequenceAsDoubleFail() {
        ProgramResult result = new Interpreter().process(
                "var x = {1, 3} " +
                        "out reduce({0, 4} , x , n m -> n + m)").get();
        assertFalse(result.getErrors().isEmpty());
    }

    @Test
    public void globalVarDoubleAsSequenceFail() {
        ProgramResult result = new Interpreter().process(
                "var x = 6 " +
                        "out reduce(x , 3 , n m -> n + m)").get();
        assertFalse(result.getErrors().isEmpty());
    }

    @Test
    public void globalVarUseBeforeDefFail() {
        ProgramResult result = new Interpreter().process(
                "out reduce({1 , 10} , x , n m -> n + m) " +
                        "var x = 6 ").get();
        assertFalse(result.getErrors().isEmpty());
    }

    @Test
    public void globalVarDoubleDefFail() {
        ProgramResult result = new Interpreter().process(
                "var x = {1, 34} " +
                        "var x = 6 ").get();
        assertFalse(result.getErrors().isEmpty());
    }

    @Test
    public void globalVarUseInLambdaFail() {
        ProgramResult result = new Interpreter().process(
                "var x = 6 " +
                        "out reduce({1,5} , 3 , n m -> x + m)").get();
        assertFalse(result.getErrors().isEmpty());
    }

    @Test
    public void globalVarUseAsLambdaParamFail() {
        ProgramResult result = new Interpreter().process(
                "var x = 6 " +
                        "out reduce({1,5} , 3 , x m -> m + 1)").get();
        assertFalse(result.getErrors().isEmpty());
    }


    @Test
    public void exampleTestSuccess() throws IOException {
        String test = getResourceFileAsString("grammarTest.txt");
        Interpreter interpreter = new Interpreter();
        ProgramResult result = interpreter.process(test).get();
        assertTrue(result.getErrors().isEmpty());
        assertTrue(result.getOutput().startsWith("pi = 3.14"));
    }

    /**
     * Reads given resource file as a string.
     *
     * @param fileName path to the resource file
     * @return the file's contents
     * @throws IOException if read fails for any reason
     */
    private String getResourceFileAsString(String fileName) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try (InputStream is = classLoader.getResourceAsStream(fileName)) {
            if (is == null)
                return null;
            try (InputStreamReader isr = new InputStreamReader(is);
                 BufferedReader reader = new BufferedReader(isr)) {
                return reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        }
    }

}