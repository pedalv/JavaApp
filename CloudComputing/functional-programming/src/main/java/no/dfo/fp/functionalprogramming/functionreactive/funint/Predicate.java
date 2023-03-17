package no.dfo.fp.functionalprogramming.functionreactive.funint;

import java.util.Objects;

public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> and(Predicate<T> other) {
        Objects.requireNonNull(other);
        return t -> test(t) && other.test(t) ;
    }

    default Predicate<T> or(Predicate<T> other) {
        Objects.requireNonNull(other);
        return t -> test(t) || other.test(t);
    }

    static <U> Predicate<U> isEqualsTo(U u) {
        return s -> s.equals(u);
    }

}
