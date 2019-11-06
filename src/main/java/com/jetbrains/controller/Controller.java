package com.jetbrains.controller;

import com.jetbrains.model.Interpreter;
import com.jetbrains.view.Editor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Controller {
    private final Logger logger = LoggerFactory.getLogger(Controller.class);
    private Interpreter interpreter;
    private Thread thread = new Thread();
    private Editor view;

    public Controller() {
        view = new Editor(this);
        interpreter = new Interpreter();
    }

    public void onInputChange() {
        thread.interrupt();
        thread = new Thread(() ->
        {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                return;
            }
            logger.info("running interpreter");
            view.applyInterpreterResults(interpreter.process(view.getInputText()));
        });
        thread.start();
    }
}
