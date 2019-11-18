package com.jetbrains.simpleinterpreter.model.asthandlers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.LongStream;

/**
 * Represent sequence in interpretation
 * @implNote Could be stored in two different states: <br>
 *     as integer sequence form <b>start</b> to <b>finish</b> inclusive or <br>
 *     as array of doubles
 */
public class Sequence implements Iterable<Double> {

    private final double[] array;
    private final long start;
    private final long finish; //inclusive

    Sequence(double[] list) {
        this.array = list;
        this.start = 0;
        this.finish = 0;
    }

    Sequence(long start, long finish) {
        this.array = null;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public Iterator<Double> iterator() {
        if (array == null)
            return LongStream.range(start, finish + 1).asDoubleStream().iterator();
        else
            return Arrays.stream(array).iterator();
    }

    @Override
    public void forEach(Consumer<? super Double> action) {
        if (array == null) {
            LongStream.range(start, finish + 1).asDoubleStream().boxed().forEach(action);
        } else {
            Arrays.stream(array).boxed().forEach(action);
        }
    }

    @Override
    public Spliterator<Double> spliterator() {
        if (array == null) {
            return LongStream.range(start, finish + 1).asDoubleStream().boxed().spliterator();
        } else {
            return Arrays.stream(array).spliterator();
        }
    }

    int size() {
        if (array == null) {
            return (int) (finish - start + 1);
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
