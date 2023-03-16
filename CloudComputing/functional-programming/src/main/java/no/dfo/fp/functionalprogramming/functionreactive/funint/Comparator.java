package no.dfo.fp.functionalprogramming.functionreactive.funint;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {

    int compare(T t1, T t2);

    default Comparator<T> thenComparing(Comparator<? super T> cmp) {
        return (p1, p2) -> compare(p1, p2) == 0 ? cmp.compare(p1, p2) : compare(p1, p2) ;
    }

    default Comparator<T> thenComparing(Function<? super T, Comparable> f) {
        return thenComparing(comparing(f)) ;
    }

    static <U> Comparator<U> comparing(Function<U, Comparable> f) { //Comparable for Integer and String
        return (p1, p2) ->  f.apply(p1).compareTo(f.apply(p2));
    }

}
