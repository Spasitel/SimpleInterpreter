package ru.jetbrains.model.data;

@FunctionalInterface
public interface DoubleBiFunction<T> {
    T apply(double a, double b);
}
