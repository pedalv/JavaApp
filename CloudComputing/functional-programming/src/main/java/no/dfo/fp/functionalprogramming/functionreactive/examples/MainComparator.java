package no.dfo.fp.functionalprogramming.functionreactive.examples;

//import no.dfo.fp.functionalprogramming.functionreactive.funint.Comparator;

import no.dfo.fp.functionalprogramming.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainComparator {

    public static void main(String... args) {

        Comparator<String> comparatorlambda = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        String[] names = new String[]{ "PP", "PPP", "P" };
        Arrays.sort(names, comparatorlambda); //ok

        //--

        Comparator<Person> cmpAge = (p1, p2) -> p2.getAge() - p1.getAge();
        Comparator<Person> cmpFirstName = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()) ;
        Comparator<Person> cmpLastName = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()) ;

        Function<Person, Integer> f1 = Person::getAge;      // p -> p.getAge();
        Function<Person, String> f2 = Person::getLastName;  // p -> p.getLastName();
        Function<Person, String> f3 = Person::getFirstName; //p -> p.getFirstName();

        Comparator<Person> cmpPersonAge = Comparator.comparing(Person::getAge);
        Comparator<Person> cmpPersonLastName = Comparator.comparing(Person::getLastName);

        Comparator<Person> cmp = Comparator.comparing(Person::getLastName)
                .thenComparing(Person::getFirstName)
                .thenComparing(Person::getAge);

        Person p1 = new Person("David", "lastDAV", 28);
        Person p2 = new Person("Erica", "lastERI", 37);
        Person p3 = new Person("Alice", "lastALI ", 23);
        Person p4 = new Person("Brian", "lastBRI", 56);
        Person p5 = new Person("Chelsea", "lastCHEL", 46);
        Person p6 = new Person("Francisco", "lastFRA", 18);
        Person p7 = new Person("Francisco", "lastFRA", 17);

        //******************IMPORTANT*****************
        //Stream<T> sorted(Comparator<? super T> comparator);
        Stream<Person> persons = Stream.of(p1,p2,p3,p4,p5,p6,p7);
        persons
                .sorted(cmp)
                //.sorted(cmpPersonAge)
                //.sorted(cmpPersonLastName)
                //.sorted(cmpAge)
                .forEach(p -> System.out.println(p.toString())); //ok

        List<Person> personsorted = Stream.of(p1,p2,p3,p4,p5,p6,p7)
                .sorted(cmp)
                //.sorted(cmpPersonAge)
                //.sorted(cmpPersonLastName)
                //.sorted(cmpAge)
                .collect(Collectors.toList());

        List<Person> personage = Stream.of(p1,p2,p3,p4,p5,p6,p7)
                //.sorted(cmp)
                .sorted(cmpPersonAge) // from 0 to 100, Comparator.comparing(Person::getAge)
                //.sorted(cmpPersonLastName)
                //.sorted(cmpAge)
                .collect(Collectors.toList());

        List<Person> personage2 = Stream.of(p1,p2,p3,p4,p5,p6,p7)
                //.sorted(cmp)
                //.sorted(cmpPersonAge)
                //.sorted(cmpPersonLastName)
                .sorted(cmpAge) //from 100 to 0, (p1, p2) -> p2.getAge() - p1.getAge()
                .collect(Collectors.toList());

        List<Person> personlastname = Stream.of(p1,p2,p3,p4,p5,p6,p7)
                //.sorted(cmp)
                //.sorted(cmpPersonAge)
                .sorted(cmpPersonLastName)
                //.sorted(cmpAge)
                .collect(Collectors.toList());


        //Collections.sort(persons, cmp); //  no suitable method found for sort(Person[],no.dfo.fp.functionalprogramming.functionreactive.funint.Comparator<Person>)

        //public static <T> void sort(T[] a, Comparator<? super T> c) { ... }
        Person[] personsa = new Person[]{ p1,p2,p3,p4,p5,p6 };
        Arrays.sort(personsa, cmp);
        Arrays.sort(personsa, cmpPersonAge);
        Arrays.sort(personsa, cmpPersonLastName);
        //Collections.sort(personsa, cmp); //  no suitable method found for sort(Person[],no.dfo.fp.functionalprogramming.functionreactive.funint.Comparator<Person>)

        List<Person> persons2 = new ArrayList<>(List.of(p1, p2, p3, p4)); // mutable list
        persons2.forEach(p -> System.out.println(p.toString()));
        persons2.sort(cmp);   //OK          // incompatible types:
        persons2.forEach(p -> System.out.println(p.toString()));
        persons2.sort(cmpAge); //OK
        Collections.sort(persons2, cmp); //OK


        List<Person> persons3 = Arrays.asList(p1, p2, p3, p4); // cant add or remove
        persons3.sort(cmp); //OK

    }

}
