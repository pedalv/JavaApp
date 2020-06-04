package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.reviewquestions.q17;

public enum AnimalClasses {

    MAMMAL(true), FISH(Boolean.FALSE), BIRD(false), // Line 2
    REPTILE(false), AMPHIBIAN(false), INVERTEBRATE(false); // Line 3
    /*
    Error:(15, 5) java: ',', '}', or ';' expected
    Error:(15, 12) java: '}' expected
    Error:(18, 12) java: class, interface, or enum expected
    Error:(20, 5) java: class, interface, or enum expected
    Error:(22, 12) java: class, interface, or enum expected
    Error:(24, 5) java: class, interface, or enum expected
    Error:(26, 12) java: class, interface, or enum expected
    Error:(28, 5) java: class, interface, or enum expected

     */

    boolean hasHair; // lINE 4


    /*
    Error:(26, 12) java: modifier public not allowed here
     */
    /*public*/ AnimalClasses(boolean hasHair) { // lINE 5
        this.hasHair = hasHair; // lINE 6
    } // lINE 7

    public boolean hasHair() { // lINE 8
        return hasHair; // lINE 9
    } // lINE 10

    public void giveWig() { // lINE 11
        hasHair = true; // lINE 12
    } // lINE 13

}

/*
What is the result of the following code? (Choose all that apply.)

    A. Compiler error on line 2.
B. Compiler error on line 3.
C. Compiler error on line 5.
    D. Compiler error on line 8.
    E. Compiler error on line 12.
    F. Compiler error on another line.
    G. The code compiles successfully.


ANSWER
B, C.
Enums are required to have a semicolon after the list of values
    if there is anything else in the enum.
Don’t worry; you won’t be expected to track down missing semicolons on the
    whole exam—only on enum questions.
Enums are not allowed to have a public constructor.

 */