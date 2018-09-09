package no.book.chapter1AdvancedClassDesign.reviewquestions.q09;

public class Outer {
    private int x = 24;

    public int getX() {
        String message = "x is ";

        class Inner {

            private int x = Outer.this.x + 1;

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

 */