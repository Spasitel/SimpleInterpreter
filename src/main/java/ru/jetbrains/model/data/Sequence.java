package ru.jetbrains.model.data;

import java.util.List;

public class Sequence implements Data {
    private final List<Double> sequence;

    public Sequence(List<Double> sequence) {
        this.sequence = sequence;
    }

    @Override
    public DataType getType() {
        return DataType.SEQUENCE;
    }

    public List<Double> getSequence() {
        return sequence;
    }
}
