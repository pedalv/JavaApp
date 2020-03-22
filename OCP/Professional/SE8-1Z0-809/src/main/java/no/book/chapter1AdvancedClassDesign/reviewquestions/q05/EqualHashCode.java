package no.book.chapter1AdvancedClassDesign.reviewquestions.q05;

public class EqualHashCode {

    private String a,b;


    public static void checkEqualHashCode(String a, String b) {

        if(a.equals(b) == true && a.hashCode() == b.hashCode()) {
            System.out.println("If a.equals(b) is true, a.hashCode() == b.hashCode() is always true.");
        }

        // If a.equals(b) is true, a.hashCode() == b.hashCode() is sometimes but no always true. - NO NO NO


        if(a.equals(b) == false && (a.hashCode() == b.hashCode()) == false ) {
            System.out.println("If a.equals(b) is false, a.hashCode() == b.hashCode() can never be true.");
        }

        // If a.equals(b) is false, a.hashCode() == b.hashCode() can sometimes be true.

    }

    public static void main(String ... args) {

        String a = "ocp", b = "ocp";
        checkEqualHashCode(a,b);

        System.out.println("--");

        a = "OCP";
        b = "ocp";
        checkEqualHashCode(a,b);

        System.out.println("--");
   }

}

/*

Which of the following statements are true, assuming a and b are String objects? (Choose
all that apply.)

A. If a.equals(b) is true, a.hashCode() == b.hashCode() is always true.
    B. If a.equals(b) is true, a.hashCode() == b.hashCode() is sometimes but not always true.
        C. If a.equals(b) is false, a.hashCode() == b.hashCode() can never be true.
D. If a.equals(b) is false, a.hashCode() == b.hashCode() can sometimes be true.

ANSWER
A
D

The relevant rule is that two objects that return true for equals() objects must
    return the same hash code.
Therefore A is correct and B is incorrect.

Two objects with the same hash code may or may not be equal.
This makes C incorrect and D correct.
The fact that two objects are not equal does not guarantee or preclude them from sharing a hash code.
Remember that hashCode() tells you which bucket to look in
    and equals() tells you whether you have found an exact match.

 */