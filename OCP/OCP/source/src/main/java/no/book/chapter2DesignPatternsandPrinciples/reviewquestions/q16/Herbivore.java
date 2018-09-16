package no.book.chapter2DesignPatternsandPrinciples.reviewquestions.q16;

public interface Herbivore { // Line 1

    int amount = 10; // Line 2

    //TODO
    public static void eatGrass() {}; // Line 3

    // TODO
    public default int chew() { // Line 4
        return 13; // Line 5
    } // Line 6

} // Line 7

/*
Choose the correct statement about the following code:

    A. It compiles and runs without issue.
    B. The code will not compile because of line 2.
C. The code will not compile because of line 3.
D. The code will not compile because of line 4.
    E. The code will not compile because of lines 2 and 3.
F. The code will not compile because of lines 3 and 4.

ANSWER



 */