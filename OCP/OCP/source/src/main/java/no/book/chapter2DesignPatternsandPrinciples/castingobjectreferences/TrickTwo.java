package no.book.chapter2DesignPatternsandPrinciples.castingobjectreferences;

/*
Casting is not without its limitations.
Even though two classes share a related hierarchy,
    that doesn’t mean an instance of one can automatically be cast to another.

Here’s an example:
 */
public class TrickTwo {

}


class Rodent {
}

class Capybara extends Rodent {

    public static void main(String[] args) {
        Rodent rodent = new Rodent();
        Capybara capybara = (Capybara) rodent; // Throws ClassCastException at runtime
        /*
        Exception in thread "main" java.lang.ClassCastException:
            no.book.chapter2DesignPatternsandPrinciples.castingobjectreferences.Rodent
            cannot be cast to no.book.chapter2DesignPatternsandPrinciples.castingobjectreferences.Capybara
	        at no.book.chapter2DesignPatternsandPrinciples.castingobjectreferences.Capybara.main(TrickTwo.java:22)
         */

        /*
        This code creates an instance of Rodent and then tries to cast it to a subclass of
            Rodent, Capybara.
        Although this code will compile without issue, it will throw a ClassCastException
            at runtime since the object being referenced is not an instance of the
            Capybara class.
        As you may recall from Chapter 1, you can use the instanceof operator
            prior to casting the object to avoid throwing ClassCastException at runtime:
         */
        if(rodent instanceof Capybara) { // IMPORTANT IMPORTANT IMPORTANT
            capybara = (Capybara)rodent;
        }

        /*
        When faced with a question on the exam that involves casting and polymorphism, be
            sure to remember what the instance of the object actually is.
        Then focus on whether the compiler will allow the object to be referenced
            with or without explicit casts.
         */
    }

}

