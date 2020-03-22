package no.book.chapter1AdvancedClassDesign.creatingnestedclasses.localinnerclasses;

/*
Which of the variables do you think are effectively final in this code?

one is effectively final.
It is only set in the line in which it is declared.

two is not effectively final.
The value is changed on line 37 after it is declared.

three is effectively final because it is assigned only once.
This assignment may happen in either branch of the if statement,
    but it can happen in only one of them.

four is not effectively final.
Even though the assignment happens after the inner class, it is not allowed.
 */
public class FinalVariable { // Line 34

    public void isItFinal() {

        /*final*/ int one = 20;

        int two = one;
        two++; // Line 37

        /*final*/ int three;
        if ( one == 4)
            three = 3;
        else
            three = 4;

        int four = 4;

        class Inner { }

        four = 5;
    }

}
