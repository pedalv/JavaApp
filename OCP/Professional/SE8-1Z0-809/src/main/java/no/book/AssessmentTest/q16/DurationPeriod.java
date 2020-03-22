package no.book.AssessmentTest.q16;

import java.time.Duration;
import java.time.Period;

public class DurationPeriod {

    public static void main(String ... args) {

        String d = Duration.ofDays(1).toString(); // PT24H
        String p = Period.ofDays(1).toString(); // P1D
        boolean b1 = d == p;
        boolean b2 = d.equals(p);
        System.out.println(b1 + " " + b2);

    }

}

/*
Which of the answer choices is printed out by the following code?
String d = Duration.ofDays(1).toString();
String p = Period.ofDays(1).toString();
boolean b1 = d == p;
boolean b2 = d.equals(p);
System.out.println(b1 + " " + b2);
A. false false
B. false true
C. true false
D. true true
E. The code does not compile.
F. A runtime exception is thrown.


Answer
A

d is the String P1D and p is the String PT24H.
They are neither the same object nor the same value.
Remember that Duration uses hours/minutes/seconds
    and Period uses years/months/days for measures.
For more information, see Chapter 5.
 */
