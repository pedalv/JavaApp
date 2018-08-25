package no.book.chapter2DesignPatternsandPrinciples.workingwithdesignpatterns.builderpattern;


import no.book.chapter2DesignPatternsandPrinciples.workingwithdesignpatterns.immutablepattern.AnimalImmutable;

import java.util.Arrays;
import java.util.List;

/*
Problem
How do we create an object that requires numerous values to be set at the time
the object is instantiated?

Motivation
As our data objects grow in size, the constructor may grow to contain many attributes.
For example, in our most recent immutable Animal class example, we had three input parameters:
    species , age , and favoriteFoods.
If we want to add fi ve new attributes to the object, we’d have to add fi ve new values in the constructor.
Every time we add a parameter, the constructor grows!
Users who reference our object would also be required to update their constructor
    calls each time that the object was modified,
    resulting in a class that would be difficult to use and maintain.
Alternatively, we could add a new constructor each time we add a parameter,
    but having too many constructors can be quite difficult to manage in practice.
One solution is to use setter methods instead of the constructor to configure the object,
    but this doesn’t work for immutable objects since they can’t be modified after creation.
For mutable objects, it could also lead to class invariants being temporarily broken.
For example, the attributes of the class may be dependent on each other, and setting them one
    at a time may expose a state where the object is not properly configured.
 */
public class UsingtheBuilderPattern {
/*
Introducing anti‐Patterns
The problem of a constructor growing too large actually has a name, referred to as the
    telescoping constructor anti‐pattern.
An anti‐pattern is a common solution to a reoccurring problem that tends to lead to unmanageable
    or difficult‐to‐use code.
Anti‐patterns often appear in complex systems as time goes on, when developers implement a series
    of successive changes without considering the long‐term effects of their actions.
For example, with the telescoping constructor anti‐pattern, the class may start off with
 only two parameters in the constructor.
Another developer may come in and added another parameter, thinking “It’s only one more!”.
A third developer may update the class and add a fourth parameter, and so on,
    until the class has 50 or 60 parameters in the constructor and
    is in desperate need of rewriting, also called refactoring.
The reason why this is an anti‐pattern is that each time the class is modified, the developer
    is only doing minor damage to the class.
However, it eventually grows out of control.
If the class is used in a number of important places throughout the system,
    refactoring it may become difficult—in some cases nearly impossible.
Design patterns are often written to help prevent anti‐patterns from forming.

Solution
The builder pattern is a creational pattern in which parameters are passed to a builder object,
    often through method chaining, and an object is generated with a final build call.
It is often used with immutable objects, since immutable objects do not have setter methods
    and must be created with all of their parameters set, although it can be used with
    mutable objects as well.
The following is an AnimalBuilder class, which uses our immutable Animal class:
 */


    public static void main(String ... args) {
        /*
        The next thing that you might notice is that all of the setter methods return an instance
            of the builder object this.
        Builder methods are commonly chained together, often callable in any order.
        For example, the following two code snippets are both valid uses of this builder:
         */
        AnimalBuilder duckBuilder = new AnimalBuilder();
        duckBuilder
                .setAge(4)
                .setFavoriteFoods(Arrays.asList("grass","fish"))
                .setSpecies("duck");
        /*
        Notice that in the second Animal example, we never even save an instance to our builder
            object! Oftentimes, builder objects are used once and then discarded.
        */
        AnimalImmutable duck = duckBuilder.build();

        /*
        You might also notice that we never explicitly set the age in the second example.
         */
        AnimalImmutable flamingo = new AnimalBuilder()
                .setFavoriteFoods(Arrays.asList("algae","insects"))
                .setSpecies("flamingo")
                .build();
    }
}


/*
At first glance, this code might look a lot like the immutable Animal class,
    so much so that it seems like we redefined it exactly.
But there are some important differences.
First, this class is mutable, whereas the Animal class is immutable.
We can modify this class as we build it, and the result of the build method will be an immutable object.
In some ways, using the builder pattern is analogous to taking a mutable object and making it read‐only.

* here

 */
class AnimalBuilder {

    private String species;
    private int age;
    private List<String> favoriteFoods;

    public AnimalBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public AnimalBuilder setSpecies(String species) {
        this.species = species;
        return this;
    }

    public AnimalBuilder setFavoriteFoods(List<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
        return this;
    }

    /*
    Finally, we create our target object build method,
        usually named build(),
        allowing it to interact with the Animal’s constructor directly.

    You might also notice that we never explicitly set the age in the second example.
    In this scenario, age may not be required, although we could certainly write our build() method to
        throw an exception if certain required fields are not set.
    Alternatively, the build() method may also set default values for anything the user
        failed to specify on the builder object.
     */
    public AnimalImmutable build() {
        return new AnimalImmutable(species,age,favoriteFoods);
    }
}

/*
The primary advantage of the builder pattern is that,
    over time,
    this approach leads to far more maintainable code.
If a new optional field is added to the Animal class, then our code that creates objects
    using the AnimalBuilder class will not need to be changed.
In practice, a builder object often supports dozens of parameters, only a handful of which
    may be set by users of the builder at a given time.
 */

/*
IMPORTANT IMPORTANT IMPORTANT
Low coupling correlates with high cohesion.
Low coupling is often a sign of a well structured computer system,
    good design,
    supports the general goals of high reability and maintainability.
Coupling refers to the interdependencies between modules.
Coupling is the degree of interdependence between software modules,
     a measure of how closely connected two routines or modules are,
     the strength of the relationships between modules
Coupling can be "low" (also "loose" or "weak")
    - Less interdependency
    - Less coodination
    - Less information flow
    - Do only one thing good
    - supports the general goals of high reability and maintainability.
    - good design
Coupling can be "high" (also "tight" and "strong")
    - More interdependency
    - More coordination
    - More information flow
    - Do a lot of things badly

 Cohesion refers to the degree to which the elements inside a module belong together.
 Cohesion describe how related function within a single module are.
 High cohesion
  - Disable
  - Because software including robustness, reliability, reusability and understandbility
Low cohesion
    - Problems
    - Because is difficulty to maintain, test, reuse, even understood

Coupling and Cohesion
    - Software quality metrics of coupling and cohesion

Connascense
    - a change in one component would require the other component to be modified
        in order to maintain the overall connectnes of the system
    - (+++++)   coupling did for structur design
    -           connascenc fif gor object oriented design about the complexity
        caused by dependency-relationships.

Stateless
    - There is no memory (state) that is mainteined by the program
    - Every transaction is performed as if it was being done for the very first time by use of cache

Statefull, RESTfull HTTP with REST
    - The program has a memory (state)
    - Prevoius transaction are remembered and may affect the current transaction
 */


/*
Builder Pattern and Tightly Coupled Code

As stated, the AnimalBuilder class looks a lot like our target Animal class.
Furthermore, it requires direct knowledge of how to use the Animal constructor,
    mentioned earlier, which could grow to 50 or 60 parameters over time.
In this manner, the builder class and target class are considered tightly coupled.
Tight coupling is the practice of developing coupled classes that are highly dependent,
    such that a minor change in one class may greatly impact the other class.
Alternatively, loose coupling is the practice of developing coupled
    classes with minimum dependencies on one another.

Although loose coupling is preferred in practice, tight coupling is required here so that
    callers of the AnimalBuilder class never have to use the Animal class constructor directly,
    60 parameters and all.

In practice, a builder class is often packaged alongside its target class,
    either as a static inner class within the target class or within the same Java package.
One advantage of packing them together is that if one is changed, then the other can be quickly updated.
Another advantage is that writers of the target class can then choose to make the
    constructor a private or default package,
    forcing the user to rely on the builder object to obtain instances of the target class.
For example,
    if the Animal class did not have a public constructor,
    programs calling it from other packages would be required to use the AnimalBuilder class to create instances of Animal.
*/
