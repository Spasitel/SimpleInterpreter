package com.jetbrains.model.asthandlers;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Sequence implements Iterable<Double> {

    final List<Double> list;
    final int start;
    //inclusive
    final int finish;

    public Sequence(List<Double> list) {
        this.list = list;
        this.start = 0;
        this.finish = 0;
    }

    public Sequence(int start, int finish) {
        this.list = null;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public Iterator<Double> iterator() {
        if (list == null)
            return IntStream.range(start, finish + 1).asDoubleStream().iterator();
        else
            return list.iterator();
    }

    @Override
    public void forEach(Consumer<? super Double> action) {
        if (list == null) {
            IntStream.range(start, finish + 1).asDoubleStream().boxed().forEach(action);
        } else {
            list.forEach(action);
        }
    }

    @Override
    public Spliterator<Double> spliterator() {
        if (list == null) {
            return IntStream.range(start, finish + 1).asDoubleStream().boxed().spliterator();
        } else {
            return list.spliterator();
        }
    }

    public int size() {
        if (list == null) {
            return finish - start + 1;
        } else {
            return list.size();
        }
    }

    public double getFirst() {
        if (list == null) {
            return start;
        } else {
            return list.get(0);
        }
    }

    public double getLast() {
        if (list == null) {
            return finish;
        } else {
            return list.get(list.size() - 1);
        }
    }
}
