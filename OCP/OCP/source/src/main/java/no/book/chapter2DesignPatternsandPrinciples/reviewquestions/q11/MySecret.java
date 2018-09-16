package no.book.chapter2DesignPatternsandPrinciples.reviewquestions.q11;

import jdk.management.resource.ResourceId;
import no.book.chapter2DesignPatternsandPrinciples.reviewquestions.q04.Coyote;

import java.util.function.Function;

public class MySecret implements Secret {


    public String magic(double d) {

        //return "Poof";

        //String sa = (e) -> "Poof";




        //String sf = (e) -> { String f = ""; return "Poof"};

        return "";
    }

    private static Function<String, String> b() {
        return (e) -> { return "Poof";}; // b
        // B. caller((e) -> {"Poof"});
        /*
        B is incorrect because it does not use the return keyword.
         */

    }

    private static Function<String, String> f_cde() {
        // F. caller((e) -> { String f = ""; return "Poof"; });
        return (e) -> { String f = ""; return "Poof"; };
        // caller((e) -> "Poof");
        /*
        C, D, and E are incorrect because the variable e is already in use from the lambda and cannot be redefined.
        Additionally,
            C is missing the return keyword
            and E is missing the semicolon.
         */

        // D. caller((e) -> { String e = ""; return "Poof"; });
        // E. caller((e) -> { String e = ""; return "Poof" });
    }

    private static Function<String, String> a() {
        // A. caller((e) -> "Poof");
        return (e) -> "Poof"; // a
        /*
        A and F are the only correct lambda expressions that match the functional interface.
         */
    }


}

/*

Which lambda can replace the MySecret class to return the same value?
(Choose all that apply.)

A. caller((e) -> "Poof");
    B. caller((e) -> {"Poof"});
    C. caller((e) -> { String e = ""; "Poof" });
    D. caller((e) -> { String e = ""; return "Poof"; });
    E. caller((e) -> { String e = ""; return "Poof" });
F. caller((e) -> { String f = ""; return "Poof"; });

ANSWER
A, F.
B is incorrect because it does not use the return keyword.
C, D, and E are incorrect because the variable e is already in use from the lambda and cannot be redefined.
Additionally,
    C is missing the return keyword
    and E is missing the semicolon.
A and F are the only correct lambda expressions that match the functional interface.

 */