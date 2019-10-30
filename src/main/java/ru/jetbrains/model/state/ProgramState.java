package ru.jetbrains.model.state;

import ru.jetbrains.model.data.Data;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Mutable current interpretation state
 */
public class ProgramState {

    private ProgramResult result = new ProgramResult();
    private Stack<Context> ASTStack = new Stack<>();
    private Map<String, Data> globalVariables = new LinkedHashMap<>();

    public ProgramResult getResult() {
        return result;
    }

    public Stack<Context> getASTStack() {
        return ASTStack;
    }

    public Map<String, Data> getGlobalVariables() {
        return globalVariables;
    }
    //TODO

}
