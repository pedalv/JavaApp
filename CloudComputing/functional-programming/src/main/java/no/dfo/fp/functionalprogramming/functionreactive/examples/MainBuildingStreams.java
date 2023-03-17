package no.dfo.fp.functionalprogramming.functionreactive.examples;

import no.dfo.fp.functionalprogramming.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainBuildingStreams {

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4);

        Stream<Integer> stream1 = ints.stream();
        Stream<Integer> stream = Stream.of(0, 1, 2, 3, 4);

        stream.forEach(System.out::println);
        stream1.forEach(System.out::println);

        //public static<T> Stream<T> generate(Supplier<? extends T> s) { ... }
        Stream<String> streamOfStrings = Stream.generate(() -> "one"); //call that patern "one" for ever
        streamOfStrings.limit(5).forEach(System.out::println);

        //public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f) { ... }
        Stream<String> streamOfStrings2 = Stream.iterate("+", s -> s + "+"); //call that patern "+" for ever
        streamOfStrings2.limit(5).forEach(System.out::println);

        IntStream streamOfInt = ThreadLocalRandom.current().ints();
        streamOfInt.limit(5).forEach(System.out::println);


        ints
                .stream()
                .filter(i -> i > 2)
                .mapToDouble(i -> i.doubleValue())
                .average() // OptionalDouble average;
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("No value to show")
                );

        DoubleSummaryStatistics result = ints
                .stream()
                .filter(i -> i > 2)
                .mapToDouble(i -> i.doubleValue())
                //.forEach(System.out::println) // error: void cannot be dereferenced
                .peek(System.out::println)      // the peek() call can be used for logging purposes
                                                // peek() is an intermediate operation
                .summaryStatistics();           // summaryStatistics() or forEach() is a terminal operation
                                                // A terminal operation must be called to trigger the processing of a Stream
                                                // No terminal operation == no data is ever processed
                                                // A call that returns a Stream is an intermediate operation call
                                                // A call that returns something else, or void is a terminal call that triggers the processing

        double res1 = result.getAverage();
        long res2 =result.getCount();
        double res3 =result.getMin();
        double res4 =result.getMax();
        String res5 =result.toString();

        Stream.empty();
        Stream.of("one");
        Stream.of(1,2,3);
        Stream.generate(() -> "one");
        Stream.iterate("+", s -> s + "+");
        Stream<String> streamOfStrings3 = Stream.iterate("+", s -> s + "+");
        streamOfStrings3.limit(5).forEach(System.out::println);
        ThreadLocalRandom.current().ints();

        // HOW to Build Streams
        IntStream hello = "hello".chars();
        CharSequence book = "book";
        Stream<String> works = Pattern.compile("[^\\p{javaLetter}]").splitAsStream(book);
        Spliterator<String> splitters = works.spliterator();
        Path path = Path.of("dfo.no");
        try {
            Stream<String> lines = Files.lines(path);
        } catch (IOException e) { //java.nio.file.NoSuchFileException: dfo.no
            e.printStackTrace();
        }

        Stream.Builder<String> builder = Stream.builder();
        builder.add("1").add("2").add("3");
        builder.accept("4");
        Stream<String> streambuild = builder.build();
        Consumer<String> println = System.out::println;
        streambuild.forEach(println);
        //A built stream will trow an exception on an add(9 or accept() call


        Person p1 = new Person("Alice", "lastALI ", 23);
        Person p2 = new Person("Brian", "lastBRI", 56);
        Person p3 = new Person("Chelsea", "lastCHEL", 46);
        Person p4 = new Person("David", "lastDAV", 28);
        Person p5 = new Person("Erica", "lastERI", 37);
        Person p6 = new Person("Francisco", "lastFRA", 18);

        List<Person> persons = Arrays.asList(p1, p2, p3, p4); // cant add or remove);
        persons.stream()
                .skip(2)
                .limit(3)
                .filter(person -> person.getAge() > 20)
                .forEach(System.out::println);

        //Reductions
        boolean b;
        b = persons.stream().anyMatch(p -> p.getAge() > 20);
        b = persons.stream().allMatch(p -> p.getAge() > 20);
        b = persons.stream().noneMatch(p -> p.getAge() > 20);


        //int opt1 = persons.stream().findFirst(p -> p.getAge() > 20);
        Optional<Person> opt1 = persons.stream().findFirst(); //order matter and can take several interactions
        Optional<Person> opt2 = persons.stream().findAny(); //order not matter and return one the found

        int sumOfAges = persons.stream()
                .map(Person::getAge)
                .reduce(0, (a1,a2) -> a1 + a2);
        int maxOfAges = persons.stream()
                .map(Person::getAge)
                .reduce(0, (a1,a2) -> Integer.max(a1, a2)); // 0 is the identity element of the max reduction among positive integers
        Optional<Integer> opt = persons.stream()
                .map(Person::getAge)
                .reduce((a1,a2) -> Integer.max(a1, a2)); // Here no identity element is provided, so the result is wrapped in an Optional
        List<Integer> ages = persons.stream()
                //<U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner);
                .reduce(
                        new ArrayList<>(), //identity
                        (list, p) -> { list.add(p.getAge()); return list; }, //accumulator
                        (list1,list2) -> { list1.addAll(list2); return list1; } //combiner
                );


    }

}
