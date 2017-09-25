package no.the.core.platform.generics.classesinterfaces;

public class SortedPair<T extends Comparable<T>>
                            // restricted it - Error:(11, 28) java: incompatible types: java.lang.Object cannot be converted to T
{
    private final T first;
    private final T second;

    public SortedPair(final T left, final T right)
    {
        //if (left.compareTo(new Object()) < 0) // restricted it
        if (left.compareTo(right) < 0)
        {
            this.first = left;
            this.second = right;
        }
        else
        {
            first = right;
            second = left;
        }
    }

    public T getSecond()
    {
        return second;
    }

    public T getFirst()
    {
        return first;
    }

    @Override
    public String toString()
    {
        return "SortedPair{" +
            "first=" + first +
            ", second=" + second +
            '}';
    }
}
