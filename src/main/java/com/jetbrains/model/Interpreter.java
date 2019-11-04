package com.jetbrains.model;

import com.jetbrains.common.ErrorInfo;
import com.jetbrains.model.antlrGen.SimpleLexer;
import com.jetbrains.model.antlrGen.SimpleParser;
import com.jetbrains.model.state.ProgramResult;
import com.jetbrains.model.state.ProgramState;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

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
        VoidVisitor interpreterVisitor = new VoidVisitor(programState);
        try {
            interpreterVisitor.visit(tree);
        } catch (InterpreterException e) {
            ProgramResult programResult = new ProgramResult();
            programResult.getErrors().add(new ErrorInfo(e.getMsg(), e.getLine(), e.getStartIndex(), e.getStopIndex()));
            return programResult;
        } catch (Exception e) {
            ProgramResult programResult = new ProgramResult();
            programResult.getErrors().add(new ErrorInfo(e.getMessage()));
            return programResult;
        }

        return programState.getResult();
    }
}
