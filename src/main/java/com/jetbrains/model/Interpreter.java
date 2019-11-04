package com.jetbrains.model;

import com.jetbrains.model.antlrGen.SimpleParser;
import com.jetbrains.model.state.ProgramResult;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import com.jetbrains.model.antlrGen.SimpleLexer;
import com.jetbrains.model.state.ProgramState;

public class Interpreter {

    public ProgramResult process(String prog) {
        CharStream input = CharStreams.fromString(prog);
        SimpleLexer lex = new SimpleLexer(input); // transforms characters into tokens
        lex.removeErrorListeners();
        CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream
        SimpleParser parser = new SimpleParser(tokens); // transforms tokens into parse trees
        parser.removeErrorListeners();

        ErrorListener errorListener = new ErrorListener();
        parser.addErrorListener(errorListener);

        SimpleParser.ProgramContext tree = parser.program();

        if (!errorListener.getErrors().isEmpty()) {
            ProgramResult programResult = new ProgramResult();
            programResult.getErrors().addAll(errorListener.getErrors());
            return programResult;
        }

        ProgramState programState = new ProgramState();
        DoubleVisitor interpreterVisitor = new DoubleVisitor(programState);
        interpreterVisitor.visit(tree);

        return programState.getResult();
    }
}
