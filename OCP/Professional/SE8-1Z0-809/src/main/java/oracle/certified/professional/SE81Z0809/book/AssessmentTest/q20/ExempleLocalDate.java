package oracle.certified.professional.SE81Z0809.book.AssessmentTest.q20;

import java.time.LocalDate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class ExempleLocalDate {

    public static void main(String ... args) {

        LocalDate now = LocalDate.now(); // 2018-09-08

        Stream<LocalDate> s = Stream.of(now);

        UnaryOperator<LocalDate> u = l -> l; // UnaryOperator<T> extends Function<T, T>

        s // Stream<T> extends BaseStream<T, Stream<T>>
                .filter(l -> l != null) // Stream<T> filter(Predicate<? super T> predicate);
                .map(u) // <R> Stream<R> map(Function<? super T, ? extends R> mapper);
                .peek(System.out::println); // Stream<T> peek(Consumer<? super T> action);

    }

}

/*
Assume that today is June 1, 2016. What is the result of the following?

A. 2016–05–01
B. B. 2016–06–01
C. There is no output.
D. The output is something other than 2016–05–01 or 2016–06–01.
E. The code does not compile.
F. An exception is thrown.

ANSWER:
C

There is no terminal operation.
Since the intermediate operations use lazy evaluation,
    they wait for a terminal operation to run.

Since there is no terminal operation,
    peek() never runs.

For more information, see Chapter 4.


 */