package no.book.chapter1AdvancedClassDesign.reviewquestions.q09;

public class Outer {
    private int x = 24;

    public int getX() {
        String message = "x is ";
        final String msg = "String final msg " +
                "- Error:(7, 9) java: not a statement " +
                "- Error:(7, 15) java: ';' expected " +
                "- Error:(7, 29) java: <identifier> expected";

        class Inner {

            private /*(final)*/ int x = Outer.this.x + 1;

            public void printX() {
                System.out.println(message + x);
            }
        }

        Inner in = new Inner();
        in.printX();

        return x;
    }

    public static void main(String[] args) {
        new Outer().getX();
    }
}

/*
What is the result of the following code?

    A. x is 0.
B. x is 24.
    C. Line 6 generates a compiler error.
    D. Line 8 generates a compiler error.
    E. Line 11 generates a compiler error.
    F. An exception is thrown.

ANSWER
B
Outer.this.x is the correct way to refer to x in the Outer class.
In Java 7, the answer would have been D
    because you used to have to declare variables as final
    to use them in a local inner class.
In Java 8, this requirement was dropped and the variables only need to be
    effectively final, which means that the code would still compile if final were added.

 */