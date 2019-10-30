package ru.jetbrains.model.state;

public class ProgramResult {
    private String output = "";

    public String getOutput() {
        return output;
    }

    public void addToOutput(String str) {
        output += str;
    }

    //todo: errors
}
