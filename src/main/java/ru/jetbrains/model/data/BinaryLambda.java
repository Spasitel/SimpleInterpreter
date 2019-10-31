package ru.jetbrains.model.data;

public class BinaryLambda implements Data {
    private final DoubleBiFunction<?> operator;

    public BinaryLambda(DoubleBiFunction<?> operator) {
        this.operator = operator;
    }

    @Override
    public DataType getType() {
        return DataType.BINARY_LAMBDA;
    }

    public DoubleBiFunction<?> getOperator() {
        return operator;
    }
}
