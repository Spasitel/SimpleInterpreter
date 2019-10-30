package ru.jetbrains.model.state;

import ru.jetbrains.model.data.Data;
import ru.jetbrains.model.data.DataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NumericalContext implements Context {

    private final String firstLambdaParameter;
    private final String secondLambdaParameter;
    private final List<Data> children = new ArrayList<>();
    private final DataType type;

    public NumericalContext(String firstLambdaParameter,
                            String secondLambdaParameter, DataType type) {
        this.firstLambdaParameter = firstLambdaParameter;
        this.secondLambdaParameter = secondLambdaParameter;
        this.type = type;
    }

    public List<Data> getChildren() {
        return children;
    }

    @Override
    public void accept(Data data) {
        assert data.getType().equals(type);
        children.add(data);
    }

    @Override
    public DataType getReturnType() {
        return type;
    }

    @Override
    public Optional<String> getFirstLambdaParameter() {
        return Optional.ofNullable(firstLambdaParameter);
    }

    @Override
    public Optional<String> getSecondLambdaParameter() {
        return Optional.ofNullable(secondLambdaParameter);
    }

    @Override
    public Context createSimilarTemplate() {
        return new NumericalContext(firstLambdaParameter, secondLambdaParameter, type);
    }
}
