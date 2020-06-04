package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.workingwithdesignpatterns.immutableobjectpattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public /*
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