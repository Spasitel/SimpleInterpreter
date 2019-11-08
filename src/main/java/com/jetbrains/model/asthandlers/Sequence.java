package com.jetbrains.model.asthandlers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * TODO
 */
public class Sequence implements Iterable<Double> {

    private final double[] array;
    private final int start;
    private final int finish; //inclusive

    Sequence(double[] list) {
        this.array = list;
        this.start = 0;
        this.finish = 0;
    }

    Sequence(int start, int finish) {
        this.array = null;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public Iterator<Double> iterator() {
        if (array == null)
            return IntStream.range(start, finish + 1).asDoubleStream().iterator();
        else
            return Arrays.stream(array).iterator();
    }

    @Override
    public void forEach(Consumer<? super Double> action) {
        if (array == null) {
            IntStream.range(start, finish + 1).asDoubleStream().boxed().forEach(action);
        } else {
            Arrays.stream(array).boxed().forEach(action);
        }
    }

    @Override
    public Spliterator<Double> spliterator() {
        if (array == null) {
            return IntStream.range(start, finish + 1).asDoubleStream().boxed().spliterator();
        } else {
            return Arrays.stream(array).spliterator();
        }
    }

    int size() {
        if (array == null) {
            return finish - start + 1;
        } else {
            return array.length;
        }
    }

    double getFirst() {
        if (array == null) {
            return start;
        } else {
            return array[0];
        }
    }

    double getLast() {
        if (array == null) {
            return finish;
        } else {
            return array[array.length - 1];
        }
    }
}
