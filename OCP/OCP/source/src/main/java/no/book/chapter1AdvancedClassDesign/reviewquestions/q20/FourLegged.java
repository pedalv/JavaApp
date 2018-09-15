package no.book.chapter1AdvancedClassDesign.reviewquestions.q20;

public class FourLegged {

    String walk = "walk,";

    static class BabyRhino extends FourLegged {
        String walk = "toddle,";
    }

    public static void main(String[] args) {
        FourLegged f = new BabyRhino();
        BabyRhino b = new BabyRhino();
        System.out.println(f.walk);
        System.out.println(b.walk);
    }

}

/*
What is the result of the following code?

    A. toddle,toddle,
    B. toddle,walk,
C. walk,toddle,
    D. walk,walk,
        E. The code does not compile.
        F. A runtime exception is thrown.

 */
