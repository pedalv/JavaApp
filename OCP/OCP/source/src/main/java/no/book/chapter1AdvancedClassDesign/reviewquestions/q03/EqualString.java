package no.book.chapter1AdvancedClassDesign.reviewquestions.q03;

public class EqualString {

    public static void main(String ... args) {

        String s1 = "Canada";
        String s2 = new String(s1);
        if(s1 == s2) System.out.println("s1 == s2");
        if(s1.equals(s2)) System.out.println("s1.equals(s2)");

    }

}

/*
What is the result of the following code?

    A. There is no output.
    B. s1 == s2
C. s1.equals(s2)
    D. Both B and C.
    E. The code does not compile.
    F. The code throws a runtime exception.

Answer
C
 */