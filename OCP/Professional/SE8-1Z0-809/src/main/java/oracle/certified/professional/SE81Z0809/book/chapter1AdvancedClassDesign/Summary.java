package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign;

public class Summary {

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
-  Member inner classes
Member inner classes require an instance of the outer class to use.
They can access private members of that outer class.
- Local inner classes
Local inner classes are classes defined within a method.
They can also access private members of the outer class.
Local inner classes can also access final or effectively final local variables.
- Anonymous inner classes
Anonymous inner classes are a special type of local inner class that does not have a name.
Anonymous inner classes are required to extend exactly one class by name or implement exactly one interface.
- Static nested classes
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
*/

}
