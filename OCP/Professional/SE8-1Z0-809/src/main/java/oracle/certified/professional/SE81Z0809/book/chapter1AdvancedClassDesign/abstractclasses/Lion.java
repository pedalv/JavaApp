package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.abstractclasses;

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
 */
public class Lion extends Cat {

    void clean() {}

}
