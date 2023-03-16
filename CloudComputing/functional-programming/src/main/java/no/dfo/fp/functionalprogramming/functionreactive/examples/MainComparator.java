package no.dfo.fp.functionalprogramming.functionreactive.examples;

import no.dfo.fp.functionalprogramming.functionreactive.funint.Comparator;
import no.dfo.fp.functionalprogramming.model.Person;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class MainComparator {

    public static void main(String... args) {

        java.util.Comparator<String> comparatorlambda = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        String[] names = new String[]{ "PP", "PPP", "P" };
        //Arrays.sort(names, comparator);
        Arrays.sort(names, comparatorlambda);

        //--

        Comparator<Person> cmpAge = (p1, p2) -> p2.getAge() - p1.getAge() ;
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

        Person p1 = new Person("Alice", "lastALI ", 23);
        Person p2 = new Person("Brian", "lastBRI", 56);
        Person p3 = new Person("Chelsea", "lastCHEL", 46);
        Person p4 = new Person("David", "lastDAV", 28);
        Person p5 = new Person("Erica", "lastERI", 37);
        Person p6 = new Person("Francisco", "lastFRA", 18);


        //TODO - How use the new Comparator?
        //Stream<T> sorted(Comparator<? super T> comparator);
        Stream<Person> persons = Stream.of(p1,p2,p3,p4,p5,p6);
        //persons.sorted(cmp);
        //persons.sorted(cmpPersonAge);
        //persons.sorted(cmpPersonLastName);

        //persons = persons.sorted(cmp);

        //public static <T> void sort(T[] a, Comparator<? super T> c) { ... }
        Person[] personsa = new Person[]{ p1,p2,p3,p4,p5,p6 };
        //Arrays.sort(personsa, cmp);
        //Arrays.sort(personsa, cmpPersonAge);
        //Arrays.sort(personsa, cmpPersonLastName);








    }

}
