package no.book.chapter1AdvancedClassDesign.creatingnestedclasses.anonymousinnerclasses;

/*
An anonymous inner class is a local inner class that does not have a name.
It is declared and instantiated all in one statement using the new keyword.
Anonymous inner classes are required to extend an existing class or implement
    an existing interface.
They are useful when you have a short implementation that will not be
    used anywhere else.

Here’s an example:
 */
public class AnonInnerA {


    /*
        Lines 2 through 4 define an abstract class.
        Lines 6 through 8 define the inner class.
        Notice how this inner class does not have a name.
        The code says to instantiate a new SaleTodayOnly object.
        But wait.
        SaleTodayOnly is abstract.
        This is OK because we provide the class body right there—anonymously.
        Pay special attention to the semicolon on line 8.
        We are declaring a local variable on these lines.
        Local variable declarations are required to end with semicolons,
            just like other Java statements—even if they are long and
            happen to contain an anonymous inner class.
     */
    abstract class SaleTodayOnly { // Line 2
        abstract int dollarsOff();
    } // Line 4

    public int admission(int basePrice) { // Line 5

        SaleTodayOnly sale = new SaleTodayOnly() {
            int dollarsOff() { return 3; } // Line 7
        }; // Line 8

        return basePrice - sale.dollarsOff();
    }

}
