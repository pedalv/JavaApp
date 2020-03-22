package no.book.chapter1AdvancedClassDesign;

public class ExamEssentials {

    /*
    Be able to identify the output of code using instanceof.
    instanceof checks if the left operand is the same class or interface (or a subclass) as the right operand.
    If the left operand is null, the result is false.
    If the two operands are not in the same class hierarchy, the code will not compile.

    Recognize correct and incorrect implementations of equals(), hashCode(), and toString().
    public boolean equals(Object obj)
        returns false when called with null or a class of the wrong type.
    public int hashCode()
        returns a number calculated with all or some of the instance variables used in equals().
    public String toString()
        returns any String.

    Be able to create enum classes.
    enums have a list of values.
    If that is all that is in the enum, the semicolon after the values is optional.
    Enums can have instance variables, constructors, and methods.
    The constructors are required to be private or package private.
    Methods are allowed to be on the enum top level or in the individual enum values.
    If the enum declares an abstract method, each enum value must implement it.

    Identify and use nested classes.
    A member inner class is instantiated with code such as outer.new Inner();.
    Local inner classes are scoped to the end of the current block of code and not allowed to have static members.
    Anonymous inner classes are limited to extending a class or implementing one interface.
    A semicolon must end the statement creating an anonymous inner class.
    Static nested classes cannot access the enclosing class instance variables.

    In software, a wildcard character is a kind of placeholder represented by a single character,
        such as an asterisk (*),
        which can be interpreted as a number of literal characters or an empty string.
    It is often used in file searches so the full name need not be typed.

    Know how to use imports and static imports.
    Classes can be imported by class name or wildcard.
    Wildcards do not look at subdirectories.
    In the event of a conflict, class name imports take precedence.
    Static imports import static members.
    They are written as import static, not static import.
    Make sure that they are importing static methods or variables rather than class names.


    Understand the rules for method overriding and overloading.
    The Java compiler allows methods to be overridden in subclasses if certain rules are followed:
        a method must have the same signature,
        be at least as accessible as the parent method,
        must not declare any new or broader exceptions,
        and must use covariant return types.
    Methods are overloaded if
        they have the same method name but a different argument list.
    An overridden method may use the optional @Override annotation.
 */

}
