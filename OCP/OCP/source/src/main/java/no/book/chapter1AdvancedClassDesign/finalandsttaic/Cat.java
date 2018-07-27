package no.book.chapter1AdvancedClassDesign.finalandsttaic;

public class Cat {

    String name = "The Cat";
    /*
    Both static and final can be added here.
    This allows the variable to be accessed as Cat.name and prevents it from being changed.
     */
    void clean() { }
    /*
    static cannot be added here independently because the subclass overrides it.
    static could be added here, but then you wouldn’t be inheriting the method.

    The final keyword cannot be added here because the subclass method would no longer be able to override it.
     */

}
