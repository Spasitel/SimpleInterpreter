package ru.jetbrains.model;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import ru.jetbrains.model.antlrGen.SimpleLexer;
import ru.jetbrains.model.antlrGen.SimpleParser;
import ru.jetbrains.model.state.ProgramResult;
import ru.jetbrains.model.state.ProgramState;

public class Interpreter {

    public ProgramResult process(String prog) {
        CharStream input = CharStreams.fromString(prog);
        SimpleLexer lex = new SimpleLexer(input); // transforms characters into tokens
        CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream
        SimpleParser parser = new SimpleParser(tokens); // transforms tokens into parse trees
        ProgramState programState = new ProgramState();
        parser.addParseListener(new InterpreterListener(programState));
        try {
            parser.program();
        } catch (IllegalArgumentException e){
            //TODO
        }
        return programState.getResult();
    }
}
