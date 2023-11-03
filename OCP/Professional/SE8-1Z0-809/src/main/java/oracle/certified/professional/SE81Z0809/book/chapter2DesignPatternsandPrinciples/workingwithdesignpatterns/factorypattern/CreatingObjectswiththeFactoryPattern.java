package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.workingwithdesignpatterns.factorypattern;

/*
Problem
How do we write code that creates objects in which the precise type of the object
    may not be known until runtime?

Motivation
As you saw with the builder pattern, object creation can be quite complex.
We’d like some way of encapsulating object creation to deal with the complexity of object creation,
    including selecting which subclass to use,
    as well as loosely coupling the underlying creation implementation.

Solution
The factory pattern, sometimes referred to as the factory method pattern,
    is a creational pattern based on the idea of using a factory class to produce instances of objects
    based on a set of input parameters.
It is similar to the builder pattern, although it is focused on supporting class polymorphism.
Factory patterns are often, although not always, implemented using static methods
    that return objects and do not require a pointer to an instance of the factory class.
It is also a good coding practice to postfix the class name with the word Factory,
    such as in AnimalFactory, ZooFactory, and so forth.
Let’s try an example of the factory pattern involving zoo animals and food.
Imagine a zookeeper who needs to feed a variety of animals in the zoo different types of foods.
Some animals eat specialized food, while others share the same type food.
Furthermore, a quantity value is associated with each distribution of food to an animal.
We illustrate this example with the following class definitions:
Food - Fish - Hay - Pellets

Now, let’s define a FoodFactory using the factory pattern that returns a food type
    based on some set of inputs, as shown in the following code.
For simplicity, we will use a java.lang.String representing the animal name as input,
    although you could certainly expand the data model using a class type
    or set of input parameters.
 */
public class CreatingObjectswiththeFactoryPattern {
    // Client (ZooKeeper)
    public static void main(String[] args) {
        final Food food = FoodFactory.getFood("polar bear");
        food.consumed();
    }
}

/*
Depending on the value of animalName,
    we return different types of food for use in our factory.
The factory pattern gives us a number of features.
First of all, different animals can share the same food,
    such as goat and rabbit both eating pellets but with varying quantities.
Next, notice in our ZooKeeper method that we don’t care about the particular
    type of food that we get,
    as long as it implements the Food interface.
This loose coupling of ZooKeeper and Food
    allows us to change the rules in the FoodFactory at a later date without requiring any code changes
    to our ZooKeeper class.
Of course,
    the developer could cast the object to a particular subclass of Food
    after it is returned from the FoodFactory,
    although that practice is generally discouraged when using a factory pattern
    as it creates a tightly coupled solution.
 */

class FoodFactory {

    public static Food getFood(String animalName) {
        switch(animalName) {
            case "zebra": return new Hay(100);
            case "rabbit": return new Pellets(5);
            case "goat": return new Pellets(30);
            case "polar bear": return new Fish(10);
        }
        // Good practice to throw an exception if no matching subclass could be found
        throw new UnsupportedOperationException("Unsupported animal: "+animalName);
    }

}

/*
Factory Pattern and Default Class Constructors

You may notice that in this example all of the Food class and subclass constructors are marked public.
We obviously could not mark the constructors private,
    as this would prevent the FoodFactory class from creating any instances of Food classes.
We could also not mark them protected,
    since the FoodFactory class is not a subclass of any of the Food classes, nor should it be.

The only problem with marking them public is that any class could by pass our factory pattern
    and create instances of the Food classes directly.
If we wanted to tighten our access control,
    we could have declared these constructors with default or package‐level access in which there is no modifier.

The advantage of using default access is that it forces any class outside the package
    into using the FoodFactory class to create an instance of a Food object,
    thereby preventing it from instantiating a Food object directly.
The only limitation is that our FoodFactory and all of our Food classes must be set in the same Java package.
If a Food class exists in a different package than FoodFactory, and we want to use FoodFactory to create an
    instance of it, then it must provide a public method.
 */

/*
As an alternative to using a factory pattern,
    a developer could implement a set of Animal classes and define a getFood() method
    in each class that returns a Food object.
The limitation in this solution is that it tightly couples what an animal is
    and what food an animal eats.
For example,
    if a particular food were no longer available,
    all of the many classes that use that particular food would need to be changed.
By using a factory pattern, we create loosely coupled code that is more resistant
    to changes in animal feeding behaviors.
 */

/*
Design Patterns: Elements of Reusable Object‐Oriented Software

If you have enjoyed this chapter on software design patterns,
    we recommend that you read the book
    Design Patterns (Addison‐Wesley Professional, 1994),
    whose authors Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides
    are often referred to humorously as the “Gang of Four.”

Design Patterns is considered one of the most influential software engineering books ever written,
    and it established the foundation of many of the design patterns that we use today.
Although we have reviewed everything you need to know to answer questions about design patterns on the OCP exam,
    the value of the knowledge offered in
    Design Patterns
    on building better and more powerful software applications cannot be overstated.
 */
