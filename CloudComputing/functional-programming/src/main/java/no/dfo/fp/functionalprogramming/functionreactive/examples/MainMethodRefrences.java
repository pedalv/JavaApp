package no.dfo.fp.functionalprogramming.functionreactive.examples;

import no.dfo.fp.functionalprogramming.model.Person;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class MainMethodRefrences {

    public static void main(String... args) {

        BinaryOperator<Integer> sum1 = (i1, i2) -> i1 + i2;
        int result1 = sum1.apply(1, 2);
        BinaryOperator<Integer> sum2 = (i1, i2) -> Integer.sum(i1, i2);
        int result2 = sum2.apply(1, 2);
        BinaryOperator<Integer> sum3 = Integer::sum;
        int result3 = sum3.apply(1, 2);
        BinaryOperator<Integer> max = Integer::max;
        int resultmax = max.apply(1, 2);

        //--

        Function<Person, Integer> f1 = Person::getAge;      // p -> p.getAge();

        //--

        Consumer<String> printer1 = s -> System.out.println(s);
        Consumer<String> printer = System.out::println;

    }

}
