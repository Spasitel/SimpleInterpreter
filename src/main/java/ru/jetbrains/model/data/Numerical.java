package ru.jetbrains.model.data;

import java.util.Objects;

public class Numerical implements Data {
    private final double value;

    public Numerical(double value) {
        this.value = value;
    }

    @Override
    public DataType getType() {
        return DataType.NUMERICAL;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Numerical numerical = (Numerical) o;
        return Double.compare(numerical.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
