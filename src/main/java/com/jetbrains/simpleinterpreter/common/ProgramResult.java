package com.jetbrains.simpleinterpreter.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Result of parsing and interpretation. Contains output of program or errors.
 */
public class ProgramResult {
    private String output = "";
    private List<ErrorInfo> errors = new ArrayList<>();

    public String getOutput() {
        return output;
    }

    public void addToOutput(String str) {
        output += str;
    }

    public List<ErrorInfo> getErrors() {
        return errors;
    }
}
