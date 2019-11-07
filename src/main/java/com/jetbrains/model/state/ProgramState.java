package com.jetbrains.model.state;

import com.jetbrains.common.ProgramResult;
import com.jetbrains.model.asthandlers.Sequence;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Mutable current interpretation state
 */
public class ProgramState {
    private ProgramResult result = new ProgramResult();
    private Map<String, Double> globalDoubleVariables = new LinkedHashMap<>();
    private Map<String, Double> lambdaParameters = new LinkedHashMap<>();
    private Map<String, Sequence> globalSequenceVariables = new LinkedHashMap<>();

    public ProgramResult getResult() {
        return result;
    }

    public Map<String, Double> getGlobalDoubleVariables() {
        return globalDoubleVariables;
    }

    public Map<String, Double> getLambdaParameters() {
        return lambdaParameters;
    }

    public Map<String, Sequence> getGlobalSequenceVariables() {
        return globalSequenceVariables;
    }
}
