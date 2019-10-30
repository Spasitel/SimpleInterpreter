package ru.jetbrains.model.data;

import java.util.function.DoubleUnaryOperator;

public class UnaryLambda implements Data {
    private final DoubleUnaryOperator operator;

    public UnaryLambda(DoubleUnaryOperator operator) {
        this.operator = operator;
    }

    @Override
    public DataType getType() {
        return DataType.UNARY_LAMBDA;
    }

    public DoubleUnaryOperator getOperator() {
        return operator;
    }
}
