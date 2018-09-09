package no.book.chapter1AdvancedClassDesign.reviewquestions.q06;

public class FlavorsEnum {

    enum Flavors {
        VANILLA,
        CHOCOLATE,
        STRAWBERRY
    }

    public static void main(String[] args) {
        System.out.println(Flavors.CHOCOLATE.ordinal());
    }

}
/*
What is the result of the following code?

    A. 0
B. 1
    C. 9
    D. CHOCOLATE
    E. The code does not compile due to a missing semicolon.
    F. The code does not compile for a different reason.

ANSWER
B
 */