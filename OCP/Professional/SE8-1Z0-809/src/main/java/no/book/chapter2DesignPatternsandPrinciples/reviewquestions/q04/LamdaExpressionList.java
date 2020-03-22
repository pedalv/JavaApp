package no.book.chapter2DesignPatternsandPrinciples.reviewquestions.q04;

import jdk.management.resource.ResourceId;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.*;

public class LamdaExpressionList {

    static void methodBeingCalled(Function<Integer, String> function) {}
    static void methodBeingCalled(IntFunction<String> function) {}

    public static void main(String ... args) {

        // This will throw an exception
        //methodBeingCalled(i -> Integer.toString(i));

        // This will not
        methodBeingCalled((int i) -> Integer.toString(i));

        Predicate<Integer> isOdd = n -> n % 2 != 0;
        BinaryOperator<Integer> sum = (x, y) -> x + y;
        Callable<Integer> callMe = () -> 42;
        //Block<String> printer -> (String s) -> { System.out.println(s); };
        Runnable runner = () -> { System.out.println("Hello World!"); };

        a();
        b();
        c();
        d();
        e();
        f();
        g();

    }

    private static void  g() {
        // ERROR
        //(Animal z, m) -> a
        /*
        Finally, G is incorrect,
            as specifying the data type for one parameter in a lambda expression
            requires you to specify the data type for all parameters in the expression.
        In this case, z has a data type and m does not, therefore the expression is invalid.

         */
    }


    private static Runnable f() {
        return () -> { };
        //() ->
        /*
        F is incorrect, as it has no right-side expression.
         */
    }

    /**
     * Package java.util.function
     * Functional interfaces provide target types for lambda expressions and method references.
     * @return
     */
    private static Function<Wolf, Integer> e() {
        return (Wolf w) -> 39;
        //Wolf w -> 39
        /*
        E is incorrect, as parentheses are required when using the data type Wolf.
         */
    }

    /**
     * Functional Interface:
     * This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.
     */
    private static Consumer<Camel> d() {
         return (Camel c) -> { return; };
         // (Camel c) -> {return;}
         /*
         D is correct, as the expression takes one Camel input and returns void.
          */
    }

    /**
     * Package java.util.function
     * Functional interfaces provide target types for lambda expressions and method references.
     * @return
     */
    private static Function<Coyote, Integer> c() {
        return (Coyote y) -> {return 0;};
        //(Coyote y) -> return 0;
        /*
        C is incorrect, as brackets {} are required when using return.
         */
    }


    Function<Integer,Integer> add1 = x -> x + 1;
    Function<String,String> concat = x -> x + 1;

    Function<Integer, String> getMyFunction() {
        return (it) -> { return "Hello, world: " + it; };
        //return it -> "Hello, world: " + it;
        //return (it) -> "Hello, world: " + it;
    }

    /**
     * Functional Interface:
     * This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.
     * @return
     */
    private static BinaryOperator<Integer>  b() {
        return (x, y) -> x + y;
        //x,y -> x+y
        /*
        B is incorrect, as more than one parameter requires parentheses ().
         */

    }

    /**
     * Functional Interface:
     * This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.
     */
    private static ResourceId a() {
         return () -> "";
         // () -> ""
        /*
        The first lambda expression is valid, taking no arguments and returning the empty string, so A is correct.
         */
    }

}

/*
Which of the following are valid lambda expressions? (Choose all that apply.)

A. () -> ""
    B. x,y -> x+y
    C. (Coyote y) -> return 0;
D. (Camel c) -> {return;}
    E. Wolf w -> 39
    F. () ->
    G. (Animal z, m) -> a

ANSWER
A, D.
The first lambda expression is valid, taking no arguments and returning the empty string, so A is correct.
B is incorrect, as more than one parameter requires parentheses ().
C is incorrect, as brackets {} are required when using return.
D is correct, as the expression takes one Camel input and returns void.
E is incorrect, as parentheses are required when using the data type Wolf.
F is incorrect, as it has no right-side expression.
Finally, G is incorrect, as specifying the data type for one parameter in a lambda expression
    requires you to specify the data type for all parameters in the expression.
In this case, z has a data type and m does not, therefore the expression is invalid.

 */