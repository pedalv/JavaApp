package no.the.core.platform.collections;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class MyComparator implements Comparator<MyClass> {
    @Override
    public int compare(MyClass x, MyClass y) {
        return x.getLabel().compareToIgnoreCase(y.getLabel());
    }

    @Override
    public Comparator<MyClass> reversed() {
        return null;
    }

    @Override
    public Comparator<MyClass> thenComparing(Comparator<? super MyClass> other) {
        return null;
    }

    @Override
    public <U> Comparator<MyClass> thenComparing(Function<? super MyClass, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return null;
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<MyClass> thenComparing(Function<? super MyClass, ? extends U> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<MyClass> thenComparingInt(ToIntFunction<? super MyClass> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<MyClass> thenComparingLong(ToLongFunction<? super MyClass> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<MyClass> thenComparingDouble(ToDoubleFunction<? super MyClass> keyExtractor) {
        return null;
    }
}
