package no.the.core.platform.generics.classesinterfaces;

import no.the.core.platform.generics.model.Person;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person>
{
    @Override
    public int compare(Person left, Person right)
    {
        // from young to older
        return Integer.compare(left.getAge(), right.getAge());
        // from older to young
        //return -1 * Integer.compare(left.getAge(), right.getAge());
        // Collections.sort(madMen, new Reverser<>(new AgeComparator()));
    }

}
