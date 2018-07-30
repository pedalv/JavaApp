package no.book.chapter1AdvancedClassDesign.creatingnestedclasses.localinnerclasses;

/*
Ready for an example?
Here’s a complicated way to multiply two numbers:

Lines 5 through 9 are the local inner class.
That class’s scope ends on line 12 where the method ends.
Line 7 refers to an instance variable and a final local variable,
    so both variable references are allowed from within the local inner class.
Earlier, we made the statement that local variable references are allowed
    if they are final or effectively final.
Let’s talk about that now.
The compiler is generating a class file from your inner class.
A separate class has no way to refer to local variables.
If the local variable is final, Java can handle it by passing it to
    the constructor of the inner class or by storing it in the class file.
If it weren’t effectively final, these tricks wouldn’t work because the value
    could change after the copy was made.
Up until Java 7, the programmer actually had to type the final keyword.
In Java 8, the “effectively final” concept was introduced.
If the code could still compile with the keyword final inserted
    before the local variable, the variable is effectively final.

Remember that the “effectively final” concept was introduced in Java 8. If
you are looking at older mock exam questions online, some of the answers
about local variables and inner classes might be different.
 */
public class Outer {

    private int length = 5;

    public void calculate() {

        final int width = 20;

        class Inner { // Line 5

            public void multiply() {
                System. out .println(length * width); // Line 7
            }

        }  // Line 9

        Inner inner = new Inner();
        inner.multiply();
    } // Line 12

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.calculate();
    }

}
