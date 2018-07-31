package no.book.chapter1AdvancedClassDesign;

public class Sumary {

/*
INSTANCEOF
The instanceof keyword compares an object to a class or interface type.
It also looks at subclasses and subinterfaces.
x instanceof Object returns true unless x is null.
If the compiler can determine that there is no way for instanceof to return true, it will generate a compiler error.

VIRTUAL METHOD
Virtual method invocation means that Java will look at subclasses when finding the right method to call.
This is true, even from within a method in the superclass.


toString(),
equals(),
and hashCode()
The methods toString(), equals(), and hashCode() are implemented in Objects
    that classes can override to change their behavior.
toString() is used to provide a human‐readable representation of the object.
equals() is used to specify which instance variables should be considered for equality.
equals() is required to return false when the object passed in is null or is of the wrong type.
hashCode() is used to provide a grouping in some collections.
hashCode() is required to return the same number when called with objects that are equals().

ENUM
The enum keyword is short for enumerated values or a list of values.
Enums can be used in switch statements.
They are not int values and cannot be compared to int values.
In a switch, the enum value is placed in the case.
Enums are allowed to have instance variables, constructors, and methods.
Enums can also have value‐specific methods.
The enum itself declares that method as well.
It can be abstract, in which case all enum values must provide an implementation.
Alternatively, it can be concrete, in which case enum values can choose whether
    they want to override the default implementation.

NESTED CLASSES
There are four types of nested classes.
Member inner classes require an instance of the outer class to use.
They can access private members of that outer class.
Local inner classes are classes defined within a method.
They can also access private members of the outer class.
Local inner classes can also access final or effectively final local variables.
Anonymous inner classes are a special type of local inner class that does not have a name.
Anonymous inner classes are required to extend exactly one class by name or implement exactly one interface.
Static nested classes can exist without an instance of the outer class.

This chapter also contained a review of
access modifiers,
overloading,
overriding,
abstract classes,
static,
final,
and imports.
It also introduced the optional @Override annotation for overridden methods or methods implemented from an interface.


Exam Essentials
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
