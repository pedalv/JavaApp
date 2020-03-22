package no.book.chapter2DesignPatternsandPrinciples.reviewquestions.q02;

public class EasternChipmunk extends Chipmunk { // Line 8

    public void chew() { System.out.println("Eastern Chipmunk is Chewing"); } // Line 9

    //TODO
    @Override
    public void climb() {

    }

} // Line 10

/*
What is the result of the following code?

    A. It compiles and runs without issue.
    B. The code will not compile because of line 2.
    C. The code will not compile because of line 4.
    D. The code will not compile because of line 5.
E. The code will not compile because of line 8.
    F. It compiles but throws an exception at runtime.

ANSWER:
E.
The code does not compile because EasternChipmunk inherits the abstract method climb() but does not implement it,
    therefore the correct answer is E.
B, C, and D are incorrect as they compile for various reasons.
Line 2 compiles, as non-static and non default interface methods are assumed to have the abstract modifier.
Line 4 compiles without issue as an interface can extend another interface.
Line 5 compiles without issue as an abstract class can implement an interface
    without implementing any of the abstract methods.
F is incorrect,
    as Line 8 does not compile.

 */
