package no.book.chapter2DesignPatternsandPrinciples.workingwithdesignpatterns.singletonpatterns;

/*
The first 'creational pattern' we will discuss is the singleton pattern.

Problem
How do we create an object in memory only once in an application and have it
    shared by multiple classes?

Motivation
There are times when we want only one instance of a particular type of object in memory.
For example, we might want to manage the amount of hay available for food to
    the zoo animals across all classes that use it.
We could pass the same shared HayManager object to every class and method that uses it,
    although this would create a lot of extra pointers and could be difficult to manage
    if the object is used throughout the application.
By creating a singleton HayManager object, we centralize the data and remove the need to
pass it around the application.

Solution
The 'singleton pattern' is a 'creational pattern' focused on creating only one
    instance of an object in memory within an application,
    sharable by all classes and threads within the application.
The globally available object created by the singleton pattern is referred to as a singleton.
Singletons may also improve performance by loading reusable data
    that would otherwise be time consuming to store and reload each time it is needed.
 */
public class ApplyingtheSingletonPattern {
    /*
    We present a simple implementation of our HayManager class as a singleton and discuss its various properties.
     */

}

/*
Resume
Singletons are used in situations where we need access to a single set of data throughout an application.
For example, application configuration data and reusable data caches are commonly implemented using singletons.
Singletons may also be used to coordinate access to shared resources,
    such as coordinating write access to a file.
 */
