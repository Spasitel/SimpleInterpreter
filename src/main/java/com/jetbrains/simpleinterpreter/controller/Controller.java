package com.jetbrains.simpleinterpreter.controller;

import com.jetbrains.simpleinterpreter.model.Interpreter;
import com.jetbrains.simpleinterpreter.view.Editor;

import javax.swing.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Controls the interaction between GUI and interpreter
 */
public class Controller {
    private Interpreter interpreter = new Interpreter();
    private ScheduledFuture<?> scheduledFuture;
    private Editor view;
    private ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

    public void showGui() {
        SwingUtilities.invokeLater(() -> view = new Editor(this));
    }

    public void onInputChange(String program) {
        if (scheduledFuture != null)
            scheduledFuture.cancel(true);

        scheduledFuture = service.schedule(
                new InterpreterWorker(view, interpreter, program), 500, TimeUnit.MILLISECONDS);
    }

    public void setView(Editor editor) {
        view = editor;
    }
}
