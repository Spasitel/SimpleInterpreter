package ru.jetbrains.model.state;

import ru.jetbrains.model.data.Data;
import ru.jetbrains.model.data.DataType;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Mutable current interpretation state
 */
public class ProgramState {
    private ReturnType returnType = new ReturnType(null, null, DataType.VOID);
    private ProgramResult result = new ProgramResult();
    private Map<String, Data> globalVariables = new LinkedHashMap<>();

    public ProgramResult getResult() {
        return result;
    }

    public Map<String, Data> getGlobalVariables() {
        return globalVariables;
    }

    public ReturnType getReturnType() {
        return returnType;
    }

    public void setReturnType(ReturnType returnType) {
        this.returnType = returnType;
    }

}
