package no.book.chapter2DesignPatternsandPrinciples.understandingdesignprinciples;

/*
In software development, encapsulation is the idea of combining fields and methods in
    a class such that the methods operate on the data, as opposed to the users of the class
    accessing the fields directly.
In Java, it is commonly implemented with private instance members that have public methods to retrieve
    or modify the data, commonly referred to as getters and setters, respectively.
The underlying idea of encapsulation is that no actor other than the class itself should have direct access to its data.
The class is said to encapsulate the data it contains and prevent anyone from directly accessing it.
With encapsulation, a class is able to maintain certain invariants about its internal data.
An invariant is a property or truth that is maintained even after the data is modified.
 */
public class EncapsulatingData {

    public static void main(String ... args) {
        Animal a1 = new Animal("Dog");
        a1.setAge(10);
        //a1.setAge(-10);
        /*
        Exception in thread "main" java.lang.IllegalArgumentException: Age cannot be a negative number
         */

        //Animal a2 = new Animal("");
        //Animal a3 = new Animal(null);
        /*
        Exception in thread "main" java.lang.IllegalArgumentException: Species is required
         */
    }

}

/*
As you can see in this example, species and age are both marked private,
    with public methods getSpecies() and getAge() to read the data.
Next, our setSpecies() and setAge() methods now validate the input and throw an exception if one of our
    invariants is violated.
Finally, a non‐default constructor has been added that requires a species value
    and uses the setter method to validate the input.
The advantage of this new implementation of the Animal class is that it uses encapsulation
to enforce the design principles of the class.
Anytime an instance of an Animal object is passed to a method,
    it can be used without requiring that its invariants be validated.
 */
class Animal {

    private String species;
    private int age;

    public Animal(String species) {
        this.setSpecies(species);
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        if(species == null || species.trim().length()==0) {
            throw new IllegalArgumentException("Species is required");
        }

        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<0) {
            throw new IllegalArgumentException("Age cannot be a negative number");
        }
        this.age = age;
    }
}


class BlockingDirectAccesstoPrivateClassVariables {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // At first, this may look like poor encapsulation.
        // After all, the name field can be change without enforcing any rules.
        this.name = name;

        // Since the method signature setName() did not change, the callers of this method
        //would not have to modify and recompile their code.
        this.name = (name == null || name.trim().length()==0) ? null: name;
    }


}