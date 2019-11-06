package com.jetbrains.model.state;

import com.jetbrains.common.ProgramResult;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Mutable current interpretation state
 */
public class ProgramState {
    private ProgramResult result = new ProgramResult();
    private Map<String, Double> globalDoubleVariables = new LinkedHashMap<>();
    private Map<String, Double> lambdaParameters = new LinkedHashMap<>();
    private Map<String, List<Double>> globalSequenceVariables = new LinkedHashMap<>();

    public ProgramResult getResult() {
        return result;
    }

    public Map<String, Double> getGlobalDoubleVariables() {
        return globalDoubleVariables;
    }

    public Map<String, Double> getLambdaParameters() {
        return lambdaParameters;
    }

    public Map<String, List<Double>> getGlobalSequenceVariables() {
        return globalSequenceVariables;
    }
}
