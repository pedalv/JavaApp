package no.book.AssessmentTest.q14;

import java.util.Scanner;

public class Compiles {

    static class RainException extends Exception {}
    /* 2.1
    Error: java: non-static variable this cannot be referenced from a static context
     */

    public static void main(String[] args) /* 2.2 throws RainException */ {
        try (Scanner s = new Scanner("rain")/*; String line = "";*/) { // Line 5
            /* 1
            Error: java: incompatible types: try-with-resources not applicable to variable type
                (java.lang.String cannot be converted to java.lang.AutoCloseable)
             */
            if (s.nextLine().equals("rain"))
                throw new RainException(); // 2.1 Make RainException static // Line 7
        } catch (RainException e) {
            e.printStackTrace();
            /* 2.2
            Error: java: unreported exception
            no.book.AssessmentTest.q14.Compiles.RainException;
            must be caught or declared to be thrown
             */
        } finally {
            //s.close(); // Line 9
            /* 3
            Error:(14, 13) java: cannot find symbol
              symbol:   variable s
              location: class no.book.AssessmentTest.q14.Compiles
             */
        }
    }
}

/*
How many compilation issues are in the following code?
    A. 0
    B. 1
    C. 2
D. 3
    E. 4
    F. 5

Answer
D.
Line 5 is incorrect because String does not implement AutoCloseable.
    Not all objects can be declared in a try-with-resources try clause.
Line 7 is incorrect because RainException is a checked exception and is not declared or handled.
Line 9 is incorrect because s is declared in the try clause and is therefore out of scope for the finally block.
 */