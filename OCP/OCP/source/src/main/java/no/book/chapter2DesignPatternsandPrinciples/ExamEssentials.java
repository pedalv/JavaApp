package no.book.chapter2DesignPatternsandPrinciples;

public class ExamEssentials {
    /*
    Be able to write code that declares, implements, and/or extends interfaces.
    An interface is like an abstract class that defines a set of
        public abstract methods,
        which classes implementing the interface must provide.
    A class may implement multiple interfaces as well as extend classes that implement interfaces,
        allowing for limited multiple inheritance in Java.
    Interfaces may extend other interfaces,
        although they may not extend a class and vice versa.
    Interfaces may also contain
        public static final constant values,
        public static methods,
        and public default methods.

    Know how to create and recognize a functional interface.
    A functional interface is one that has exactly one abstract method.
    It is the primary manner in which lambda expressions are passed between methods.
    Java includes a Predicate interface for testing a generic type and returning a boolean expression.

    Be able to write valid lambda expressions.
    A lambda expression is like an anonymous method that can be passed to a method,
        relying on deferred execution to process the expression at a later time.
    It has various syntax options, both long and short.
    Lambda expressions are used throughout Java 8 and in numerous questions on the exam.

    Understand polymorphism.
    An object in Java may take on a variety of forms,
        in part depending on the reference used to access the object.
    The type of the object determines which properties exist within the object in memory,
        whereas the type of the reference to the object determines
        which methods
        and variables
        are accessible to the Java program.
    An instance can be automatically cast to a superclass or interface reference
        without an explicit cast.
    Alternatively,
        an explicit cast is required if the reference is being narrowed
        to a subclass of the object.
    The Java compiler doesn’t permit casting to unrelated types.
    Finally,
        you should be able to distinguish between
        compile‐time casting errors
        and those that will not occur until runtime, throwing a ClassCastException.

    Understand the importance of design principles and design patterns.
    A design principle
        is an established idea
        or best practice
        that facilitates the software design process.
    A design pattern
        is an established general solution to a commonly occurring software development problem.

    Know how to implement encapsulation.
    Encapsulation
        is based on the idea of combining fields and methods in a class
        such that
        the methods operate on the data,
        as opposed to users of the class accessing the fields directly.
    It can be used
        to prevent users from creating object states that violate class invariants.
    In Java,
        it is often implemented with JavaBeans,
        using the private access modifier on instance variables
        and public getter and setter methods.

    Be able to apply the is‐a and has‐a tests.
    The is‐a test
        is used to test whether an object is of a particular type,
        and it is used for both classes and interfaces.
    The has‐a test
        is used to determine whether an object contains a reference to another object as an instance property.

    Be able to apply object composition and distinguish it from inheritance.
    Object composition
        is the idea of creating a class
        by connecting other classes as members using the has‐a principle.
    Inheritance
        is the idea of creating a class that inherits all of its reusable methods
        and objects from a parent class.
    Both are used to create complex data models, each with its own advantages and disadvantages.

    Be able to apply creational patterns
        including the
        singleton pattern
        and the immutable object pattern.
    The singleton and immutable object patterns
        are both types of creational patterns,
        which are design patterns that facilitate
        the creation of objects with an application.
    The singleton pattern
        solves the problem of how to create a single instance of an object in memory
        that multiple classes can share by centralizing the object‐creation mechanisms.
    The immutable object pattern
        is used to create read‐only objects
        that cannot be modified by other classes.
    Although immutable objects cannot be modified,
        they can be copied to new immutable objects with the updated information.
     */
}
