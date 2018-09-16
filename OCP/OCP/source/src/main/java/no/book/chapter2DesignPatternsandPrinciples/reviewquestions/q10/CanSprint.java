package no.book.chapter2DesignPatternsandPrinciples.reviewquestions.q10;

public interface CanSprint extends CanWalk, CanRun { // Line 8
    void sprint(); // Line 9

    @Override
    default void run() {

    }

    @Override
    default void walk() {

    }
} // Line 10

/*
What is the result of the following code?

    A. The code compiles without issue.
    B. The code will not compile because of line 5.
    C. The code will not compile because of line 6.
D. The code will not compile because of line 8.
    E. The code will not compile because of line 9.

ANSWER


 */