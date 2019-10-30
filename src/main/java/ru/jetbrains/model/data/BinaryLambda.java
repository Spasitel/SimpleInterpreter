package ru.jetbrains.model.data;

import java.util.function.DoubleBinaryOperator;

public class BinaryLambda implements Data {
    private final DoubleBinaryOperator operator;

    public BinaryLambda(DoubleBinaryOperator operator) {
        this.operator = operator;
    }

    @Override
    public DataType getType() {
        return DataType.BINARY_LAMBDA;
    }

    public DoubleBinaryOperator getOperator() {
        return operator;
    }
}
