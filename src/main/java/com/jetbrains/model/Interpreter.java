package com.jetbrains.model;

import com.jetbrains.common.ErrorInfo;
import com.jetbrains.common.ProgramResult;
import com.jetbrains.model.antlrgen.SimpleLexer;
import com.jetbrains.model.antlrgen.SimpleParser;
import com.jetbrains.model.asthandlers.ErrorListener;
import com.jetbrains.model.asthandlers.VoidVisitor;
import com.jetbrains.model.state.ProgramState;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class Interpreter {
    private final Logger logger = LoggerFactory.getLogger(Interpreter.class);

    /**
     * Parse and interpret given program
     * @param program code of the program
     * @return {@link ProgramResult} - result of interpretation or<br>
     *         empty - if interpretation was interrupted
     */
    public Optional<ProgramResult> process(String program) {
        CharStream input = CharStreams.fromString(program);
        SimpleLexer lex = new SimpleLexer(input); // transforms characters into tokens
        lex.removeErrorListeners();
        ErrorListener errorListener = new ErrorListener();
        lex.addErrorListener(errorListener);
        CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream
        SimpleParser parser = new SimpleParser(tokens); // transforms tokens into parse trees
        parser.removeErrorListeners();

        parser.addErrorListener(errorListener);

        SimpleParser.ProgramContext tree = parser.program();

        ProgramResult programResult;
        if (!errorListener.getErrors().isEmpty()) {
            logger.error("Syntax errors: " + errorListener.getErrors().size());
            programResult = new ProgramResult();
            programResult.getErrors().addAll(errorListener.getErrors());
        } else {
            try {
                ProgramState programState = new ProgramState();
                VoidVisitor visitor = VoidVisitor.createVisitors(programState);
                visitor.visit(tree);
                logger.info("Interpretation done");
                programResult = programState.getResult();
            } catch (InterpretationException e) {
                logger.error("Interpretation error: " + e.getMessage());
                programResult = new ProgramResult();
                programResult.getErrors().add(new ErrorInfo(e.getMessage(), e.getPosition()));
            } catch (Exception e) {
                logger.error("Exception: " + e.getMessage());
                programResult = new ProgramResult();
                programResult.getErrors().add(new ErrorInfo(e.getMessage()));
            }
        }

        if (Thread.interrupted())
            return Optional.empty();

        return Optional.of(programResult);
    }
}
