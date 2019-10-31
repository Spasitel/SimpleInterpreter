package ru.jetbrains.model.state;

import ru.jetbrains.model.data.DataType;

import java.util.Optional;

public class ReturnType {
    private final String firstLambdaParameter;
    private final String secondLambdaParameter;
    private final DataType type;

    public ReturnType(String firstLambdaParameter, String secondLambdaParameter, DataType type) {
        this.firstLambdaParameter = firstLambdaParameter;
        this.secondLambdaParameter = secondLambdaParameter;
        this.type = type;
    }


    public DataType getType() {
        return type;
    }

    public Optional<String> getFirstLambdaParameter() {
        return Optional.ofNullable(firstLambdaParameter);
    }

    public Optional<String> getSecondLambdaParameter() {
        return Optional.ofNullable(secondLambdaParameter);
    }
}
