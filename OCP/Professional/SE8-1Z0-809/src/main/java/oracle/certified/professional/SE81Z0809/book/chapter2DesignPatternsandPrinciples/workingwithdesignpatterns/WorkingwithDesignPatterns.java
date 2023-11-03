package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.workingwithdesignpatterns;

/*
A design pattern is an established general solution to a commonly occurring software development problem.
The purpose of a design pattern is to leverage the wealth of knowledge of developers
    who have come before you in order to solve old problems that you may encounter easily.
It also gives developers a common vocabulary in which they can discuss common problems and solutions.
For example, if you say that you wrote getters/setters or implemented the singleton pattern,
    most developers will understand the structure of your code without having to get into the low‐level details.

In this chapter, we are primarily focused on 'creational patterns' , a type of software design pattern
    that manages the creation of objects within an application.
Obviously, you already know how to create objects in Java with the new keyword,
    as shown in the following code:

Animal animal = new Camel();

The problem with object creation, though, lies in how you create and manage objects in more complex systems.
In this example, we were required to know exactly which type of Animal object, in this case Camel,
 we wanted to create at compile time.
But what if this is not known until runtime?
Furthermore, what if we wanted to create a single Animal object in memory
    that is shared by all classes within our application?
We will investigate these kinds of design creation problems and their associated patterns in this section.
One thing to keep in mind as you read this section is that under the covers,
    the new keyword is still used to create objects in memory.

The 'creational patterns' simply apply a level of indirection to object creation by creating the object in some other class,
    rather than creating the object directly in your application.
Level of indirection is a general term for solving a software design problem
    by conceptually separating the task into multiple levels.
 */
public class WorkingwithDesignPatterns {

    /*
    For the OCP 8 exam, you are required to know only the first two of the four design patterns that we present in this section:
     the singleton pattern and the immutable object pattern.
     Because of this, we will test you only on the first two patterns in any review questions in this book.
     That said, we suggest that you become familiar with all four of these patterns as they
        are used throughout the Java API, as well as in later chapters of this book.
    */

}
