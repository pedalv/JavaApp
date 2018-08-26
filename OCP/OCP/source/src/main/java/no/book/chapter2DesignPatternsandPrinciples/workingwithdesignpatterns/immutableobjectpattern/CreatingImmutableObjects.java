package no.book.chapter2DesignPatternsandPrinciples.workingwithdesignpatterns.immutableobjectpattern;

/*
Problem
How do we create read‐only objects that can be shared and used by multiple classes?

Motivation
Sometimes we want to create simple objects that can be shared across multiple
    classes, but for security reasons we don’t want their value to be modified.
We could copy the object before sending it to another method, but this creates a large overhead
    that duplicates the object every time it is passed.
Furthermore, if we have multiple threads accessing the same object,
    we could run into concurrency issues.

Solution
The immutable object pattern is a creational pattern based on the idea of creating objects
    whose state does not change after they are created and can be easily shared
    across multiple classes.
Immutable objects go hand and hand with encapsulation, except that no setter methods exist
    that modify the object.
Since the state of an immutable object never changes, they are inherently thread‐safe.

Note
You’ve actually been working with immutable objects throughout your OCA studies.
You may remember that the String class was called immutable.
 */
public class CreatingImmutableObjects {
    /*
    Applying an Immutable Strategy
    Although there are a variety of techniques for writing an immutable class,
        you should be familiar with a common strategy for making a class immutable for the exam:
    1. Use a constructor to set all properties of the object.
    The fi rst rule defines how we create the immutable object, by passing the information
        to the constructor, so that all of the data is set upon creation.
    2. Mark all of the instance variables private and final.
    3. Don’t define any setter methods.
    The second and third rules are straightforward, as they stem from proper encapsulation.
    If the instance variables are private and final, and there are no setter methods,
        then there is no direct way to change the property of an object.
    All references and primitive values contained in the object are set at creation and cannot be modified.
    4. Don’t allow referenced mutable objects to be modified or accessed directly.
    The fourth rule requires a little more explanation.
    Let’s say that you have an immutable Animal object, which contains a reference to a List of
        the animal’s favorite foods, as shown in the following example:
    5. Prevent methods from being overridden.
    It prevents someone from creating a subclass of your class in which a previously
        immutable value now appears mutable.
    For example, they could override a method that modifies a different variable in the subclass,
        essentially hiding the private variable defined in the parent class.
     The simplest solution is to mark the class or methods with the final modifier,
        although this does limit the usage of the class.
     Another option is to make the constructor private and apply the factory pattern,
        which we will discuss later in this chapter.
     */
}
