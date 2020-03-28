package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.finalandstatic;

/*
The tricky one is that you could leave it
blank. An abstract class is not required to have any methods in it, let alone any abstract
ones.

A second answer is the one that you probably thought of right away:
abstract void clean();
This one is the actual abstract method. It has the abstract keyword and a semicolon
instead of a method body

A third answer is a default implementation:
void clean () {}

An abstract class may contain any number of methods including zero.
The methods can be abstract or concrete.
Abstract methods may not appear in a class that is not abstract.
The first concrete subclass of an abstract class is required to implement all abstract
    methods that were not implemented by a superclass.
Notice that we said three ways.
There are plenty of other ways.
For example, you could have the clean() method throw a RuntimeException.


To review,
final prevents a variable from changing or a method from being overridden.

static makes a variable shared at the class level and uses the class name to refer to a method.

static and final are allowed to be added on the class level too.
You will see static classes in the section on nested classes at the end of this chapter, so don’t worry if you didn’t
    pick up on those.

Using final on a class means that it cannot be subclassed.

As with methods, a class cannot be both abstract and final.

In the Java core classes, String is final.
 */
public class Lion extends Cat {

    void clean() { }
    /*
    static cannot be added here independently because the subclass overrides it.
    static could be added here, but then you wouldn’t be inheriting the method.

    final can be added here since there are no subclasses of Lion.
     */

}
