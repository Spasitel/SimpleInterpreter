package com.jetbrains.controller;

import com.jetbrains.model.Interpreter;
import com.jetbrains.view.Editor;

import javax.swing.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 */
public class Controller {
    private Interpreter interpreter = new Interpreter();
    private ScheduledFuture<?> scheduledFuture;
    private Editor view;
    private ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

    public Controller() {
        SwingUtilities.invokeLater(() -> view = new Editor(this));
    }

    public void onInputChange(String program) {
        if (scheduledFuture != null)
            scheduledFuture.cancel(true);

        scheduledFuture = service
                .schedule(new InterpreterWorker(view, interpreter, program), 2500, TimeUnit.MILLISECONDS);
    }
}
