package ru.jetbrains.model.data;

import java.util.function.DoubleFunction;

public class UnaryLambda implements Data {
    private final DoubleFunction<?> operator;

    public UnaryLambda(DoubleFunction<?> operator) {
        this.operator = operator;
    }

    @Override
    public DataType getType() {
        return DataType.UNARY_LAMBDA;
    }

    public DoubleFunction<?> getOperator() {
        return operator;
    }
}
