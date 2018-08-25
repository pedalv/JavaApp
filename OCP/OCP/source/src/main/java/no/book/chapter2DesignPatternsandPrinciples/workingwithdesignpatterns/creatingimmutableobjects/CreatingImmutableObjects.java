package no.book.chapter2DesignPatternsandPrinciples.workingwithdesignpatterns.creatingimmutableobjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

final class Animal {

    private final List<String> favoriteFoods;

    /*
    In order to ensure that the favoriteFoods List is not null,
        we validate it in the constructor and throw an exception if it is not provided.
     */
    public Animal(List<String> favoriteFoods) {
        if(favoriteFoods == null) {
            throw new RuntimeException("favoriteFoods is required");
        }
        this.favoriteFoods = new ArrayList<String>(favoriteFoods);
    }

    /*
    The problem in this example is that the user has direct access to the List defined in our instance of Animal.
    Even though they can’t change the List object to which it points, they can modify the items in the List,
        for example, deleting all of the items by calling getFavoriteFoods().clear().
    They could also replace, remove, or even sort the List.
     */
    public List<String> getFavoriteFoods() { // MAKES CLASS MUTABLE!
        // Problem: Possible do getFavoriteFoods().clear()/replace, remove, or even sort the List.
        //return favoriteFoods;
        // Solution
        return Collections.unmodifiableList(favoriteFoods); // IMPORTANT IMPORTANT IMPORTANT
    }
    /*
    The solution, then, is never to return that List reference to the user.
    More generally stated, you should never share references to a mutable object contained within an
        immutable object.
    If the user does need access to the data in the List, either create wrapper methods to iterate
        over the data or create a one‐time copy of the data that is returned to the user and never
        stored as part of the object.
    In fact, the Collections API includes the Collections.unmodifiableList() method, which does exactly this.
    The key here is that none of the methods that you create should modify the mutable object.
     */
}


/*
Does the sample below follow all five rules?
Well, all fields are marked private and final, and the constructor sets them upon object creation.
Next, there are no setter methods and the class itself is marked final,
    so the methods cannot be overridden by a subclass.
The class does contain a mutable object, List, but no references to the object are publically available.
We provide two methods for retrieving the total number of favorite foods as well as a method to retrieve
    a food based on an index value.
Note that String is given to be immutable, so we don’t have to worry about any of the String objects being modified.
Therefore, all five rules are preserved and instances of this class are immutable.
 */
final class AnimalImmutable {
    private final String species;
    private final int age;
    private final List<String> favoriteFoods;

    public AnimalImmutable(String species, int age, List<String> favoriteFoods) {
        this.species = species;
        this.age = age;
        if(favoriteFoods == null) {
            throw new RuntimeException("favoriteFoods is required");
        }
        this.favoriteFoods = new ArrayList<String>(favoriteFoods);
    }

    public String getSpecies() {
        return species;
    }
    public int getAge() {
        return age;
    }
    public int getFavoriteFoodsCount() {
        return favoriteFoods.size();
    }
    public String getFavoriteFood(int index) {
        return favoriteFoods.get(index);
    }


    public List<String> getFavoriteFoods() { // MAKES CLASS IMMUTABLE!
        return Collections.unmodifiableList(favoriteFoods); // IMPORTANT IMPORTANT IMPORTANT
    }

}

/*
IMPORTANT IMPORTANT IMPORTANT

Handling Mutable Objects in the Constructors of Immutable Objects

You may notice that we created a new ArrayList in the Animal constructor.
This is absolutely important to prevent the class that initially creates the object
    from maintaining a reference to the mutable List used by Animal.
Consider if we had just done the following in the constructor:

this.favoriteFoods = favoriteFoods;

With this change, the caller that creates the object is using the same reference as the
    immutable object, which means that it has the ability to change the List!
It is important when creating immutable objects that any mutable input arguments
    are copied to the instance instead of being used directly.
 */