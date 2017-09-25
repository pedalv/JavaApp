package no.the.core.platform.generics.methods;

import no.the.core.platform.generics.classesinterfaces.AgeComparator;
import no.the.core.platform.generics.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SaveSortingExamples<T,S, V,U>
{
    public static void main(String[] args)
    {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> madMen = new ArrayList<Person>();
        madMen.add(donDraper);
        madMen.add(peggyOlson);
        madMen.add(bertCooper);

        final Person youngestCastMember =
                min(madMen, new AgeComparator());

        System.out.println(youngestCastMember);

        // restrict to Person - T - compile error is Integer
        final Person youngestCastMember2 =
                min(madMen, new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return 0;
                    }
                });

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        System.out.println(min(numbers, Integer::compare));
        System.out.println(min(numbers, Integer::compareTo));

        /*
            //Collections.min(list, comparator)
            public static <T> T min(Collection<? extends T> coll, Comparator<? super T> comp) {
                if (comp==null)
                    return (T)min((Collection) coll);

                Iterator<? extends T> i = coll.iterator();
                T candidate = i.next();

                while (i.hasNext()) {
                    T next = i.next();
                    if (comp.compare(next, candidate) < 0)
                        candidate = next;
                }
                return candidate;
            }

            //Collections.min(list)
             public static <T extends Object & Comparable<? super T>> T min(Collection<? extends T> coll) {
                Iterator<? extends T> i = coll.iterator();
                T candidate = i.next();

                while (i.hasNext()) {
                    T next = i.next();
                    if (next.compareTo(candidate) < 0)
                        candidate = next;
                }
                return candidate;
            }
        */

    }

    public static <T> T min(List<T> values, Comparator<T> comparator) {

        if(values.isEmpty()) {
            throw new IllegalArgumentException("List is empty, cannot find minumum");
        }

        T lowestElement = values.get(0);

        for(int i = 1; i < values.size(); i++) {
            final T element = values.get(i);
            if(comparator.compare(element, lowestElement) < 0 ) {
                lowestElement = element;
            }
        }

        return lowestElement;
    }

}
