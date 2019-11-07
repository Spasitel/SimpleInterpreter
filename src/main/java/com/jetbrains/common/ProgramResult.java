package com.jetbrains.common;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
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
