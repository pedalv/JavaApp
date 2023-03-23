package no.dfo.whatsnewinjava;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class MainpredicateNot {

    public static void main(String ...args) {
        Stream<String> strings = Stream.of("PP", "  ", "", "p");
        strings
                .filter(Predicate.not(String::isBlank))
                .forEach(System.out::println);
    }
}
