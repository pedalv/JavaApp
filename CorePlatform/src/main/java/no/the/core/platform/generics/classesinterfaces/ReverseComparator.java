package no.the.core.platform.generics.classesinterfaces;

import no.the.core.platform.generics.model.Person;

import java.util.Comparator;

public class ReverseComparator<T> implements Comparator<T> {

    private final Comparator<T> delegateComparator;

    public ReverseComparator(Comparator<T> delegateComparator) {
        this.delegateComparator = delegateComparator;
    }

    @Override
    public int compare(final T left, final T right) {
        return -1 * this.delegateComparator.compare(left, right);
    }

}
