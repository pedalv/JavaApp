package no.book.chapter2DesignPatternsandPrinciples.reviewquestions.q20;

public class Falcon implements CanFly, HasWings { // Line 7

    // TODO
    @Override
    public void fly() {

    }

    // TODO
    @Override
    public Object getWingSpan() {
        return null;
    }

} // Line 8

/*
Choose the correct statement about the following code:

    A. It compiles without issue.
    B. The code will not compile because of line 2.
    C. The code will not compile because of line 4.
    D. The code will not compile because of line 5.
    E. The code will not compile because of lines 2 and 5.
F. The code will not compile because the class Falcon doesn’t implement the interface methods.

ANSWER
A.
Although the definition of methods on lines 2 and 5 vary,
    both will be converted to public abstract by the compiler.
Line 4 is fine,
    because an interface can have public or default access.
Finally,
    the class Falcon doesn’t need to implement the interface methods
        because it is marked as abstract. Therefore, the code will compile without issue.

 */