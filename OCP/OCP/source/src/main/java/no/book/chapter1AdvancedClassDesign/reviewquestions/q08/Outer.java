package no.book.chapter1AdvancedClassDesign.reviewquestions.q08;

public class Outer {

    private int x = 5;

    protected class Inner {
        public /*static*/ int x = 10; // Line 4
        /*
        Error: java: Illegal static declaration in inner class
            no.book.chapter1AdvancedClassDesign.reviewquestions.q08.Outer.Inner
            modifier 'static' is only allowed in constant variable declarations.
            Inner classes cannot have static declarations
         */
        public void go() { System.out.println(x); }
    }

    public static void main(String[] args) {
        Outer out = new Outer(); // Line 8
        Outer.Inner in = out.new Inner(); // Line 9
        in.go();
    }
}

/*
What is the result of the following code?

    A. The output is 5.
        B. The output is 10.
C. Line 4 generates a compiler error.
    D. Line 8 generates a compiler error.
    E. Line 9 generates a compiler error.
    F. An exception is thrown.

ANSWER
C
after fix
B

C.
Inner is a member inner class.
Inner classes are not allowed to contain static methods or static variables.
Only nested static classes are permitted to contain statics.



 */