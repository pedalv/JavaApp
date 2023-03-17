package no.dfo.fp.functionalprogramming.functionreactive.examples;

import no.dfo.fp.functionalprogramming.functionreactive.funint.Predicate;
//import java.util.function.Predicate;

public class MainPredicate {

    public static void main(String[] args) {

        Predicate<String> p1 = s -> s.length() < 20 ;
        Predicate<String> p2 = s -> s.length() > 5 ;

        boolean b = p1.test("Hello"); //true
        System.out.println("Hello is shorter than 20 chars : " + b); //true

        Predicate<String> p3 = p1.and(p2) ;

        System.out.println("P3 for Yes: " + p3.test("Yes")); //false
        System.out.println("P3 for Good morning: " + p3.test("Good morning")); //true
        System.out.println("P3 for Good morning gentlemen: " + p3.test("Good morning gentlemen")); //false

        Predicate<String> p4 = p1.or(p2) ;

        System.out.println("P4 for Yes: " + p4.test("Yes")); //true
        System.out.println("P4 for Good morning: " + p4.test("Good morning")); //true
        System.out.println("P4 for Good morning gentlemen: " + p4.test("Good morning gentlemen")); //true

        Predicate<String> p5 = Predicate.isEqualsTo("Yes");

        System.out.println("P5 for Yes: " + p5.test("Yes")); //true
        System.out.println("P5 for No: " + p5.test("No")); //false

        Predicate<Integer> p6 = Predicate.isEqualsTo(1);
        System.out.println("P6 for No: " + p6.test(0)); //false
        System.out.println("P6 for No: " + p6.test(1)); //true
        System.out.println("P6 for No: " + p6.test(10)); //false

    }


}
