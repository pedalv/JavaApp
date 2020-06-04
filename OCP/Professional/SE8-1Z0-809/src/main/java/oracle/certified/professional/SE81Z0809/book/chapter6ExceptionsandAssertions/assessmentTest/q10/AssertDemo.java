package oracle.certified.professional.SE81Z0809.book.chapter6ExceptionsandAssertions.assessmentTest.q10;

public class AssertDemo { // Line 1

    public static void main(String [] args) { // Line 2
        Integer x = 10; // Line 3
        x++; // Line 4
        assert x == null && x >= 0; // Line 5
        System.out.println(x); // Line 6
    }

}

/*
OUTPUT: 11

Which of the following statements is true when the code is run with java AssertDemo?
    A. Line 3 generates a compiler error.
    B. Line 4 generates a compiler error.
    C. Line 5 generates a compiler error.
    D. Line 5 throws an AssertionError at runtime.
    E. The output is 10.
F. The output is 11.


Answer
F

The code compiles due to autoboxing.
The command line does not enable assertions, so D cannot happen.
Line 6 executes and prints out 11, so the answer is F.
For more information, see Chapter 6.

 */