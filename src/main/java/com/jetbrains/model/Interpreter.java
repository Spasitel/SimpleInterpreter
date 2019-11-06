package com.jetbrains.model;

import com.jetbrains.common.ErrorInfo;
import com.jetbrains.model.antlrgen.SimpleLexer;
import com.jetbrains.model.antlrgen.SimpleParser;
import com.jetbrains.model.asthandlers.ErrorListener;
import com.jetbrains.model.asthandlers.VoidVisitor;
import com.jetbrains.common.ProgramResult;
import com.jetbrains.model.state.ProgramState;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Interpreter {

    public ProgramResult process(String program) {
        CharStream input = CharStreams.fromString(program);
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
        VoidVisitor visitor = VoidVisitor.createVisitors(programState);
        try {
            visitor.visit(tree);
        } catch (InterpretationException e) {
            ProgramResult programResult = new ProgramResult();
            programResult.getErrors().add(new ErrorInfo(e.getMsg(), e.getPosition()));
            return programResult;
        } catch (Exception e) {
            ProgramResult programResult = new ProgramResult();
            programResult.getErrors().add(new ErrorInfo(e.getMessage()));
            return programResult;
        }

        return programState.getResult();
    }


}
