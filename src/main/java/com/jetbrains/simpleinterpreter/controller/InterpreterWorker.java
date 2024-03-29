package com.jetbrains.simpleinterpreter.controller;

import com.jetbrains.simpleinterpreter.common.ProgramResult;
import com.jetbrains.simpleinterpreter.model.Interpreter;
import com.jetbrains.simpleinterpreter.view.Editor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.util.Optional;

/**
 * Swing background task which run the interpretation and render its results (if any)
 */
public class InterpreterWorker extends SwingWorker<Optional<ProgramResult>, Void> {
    private final Logger logger = LoggerFactory.getLogger(InterpreterWorker.class);

    private Editor view;
    private Interpreter interpreter;
    private String program;

    InterpreterWorker(Editor view, Interpreter interpreter, String program) {
        this.view = view;
        this.interpreter = interpreter;
        this.program = program;
    }

    @Override
    protected Optional<ProgramResult> doInBackground() {
        logger.info("Running interpreter");
        logger.debug("Program: \n{}", program);
        return interpreter.process(program);
    }

    @Override
    protected void done() {
        try {
            Optional<ProgramResult> result = get();
            result.ifPresent(programResult -> view.applyInterpreterResults(programResult));
        } catch (Exception e) {
            //Nothing to do
        }
    }
}
