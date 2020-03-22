package no.book.chapter1AdvancedClassDesign.reviewquestions.q15;

import no.book.chapter2DesignPatternsandPrinciples.applyingthepredicateinterface.Animal;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class EqualStatement {

    public static void main(String ... args) {

        try {

            int i = 1; // i.equals(null);
            String str = ""; System.out.println(str.equals(null));
            Animal a = new Animal("", false, false); System.out.println(a.equals(null));
            Object o = null; System.out.println(o.equals(null));


        } catch (NullPointerException e) {
            System.out.println(e.getMessage() + " -> java.lang.NullPointerException: o.equals(null)");

        }


    }


    @Override
    public boolean equals(Object obj) {

        return EqualsBuilder.reflectionEquals(this, obj);

        //return super.equals(obj);
    }
}

/*
Which of the following statements are true about the equals() method?
(Choose all that apply.)

   (only with null but here can be ever thing ) --- null.equals(null) --> throw
    A. If equals(null) is called, the method should throw an exception.
B. If equals(null) is called, the method should return false.
    C. If equals(null) is called, the method should return true.
    D. If equals() is passed the wrong type, the method should throw an exception.
E. If equals() is passed the wrong type, the method should return false.
    F. If equals() is passed the wrong type, the method should return true.


ANSWER
B, E.
equals() should return false when the object it passed in is not equal to the current object.
This includes null and incorrect types.
An equals() method should have a null check and an instanceof check.

 */


