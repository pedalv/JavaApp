package no.book.chapter1AdvancedClassDesign.usinginstanceof;

/*
In a instanceof B, the expression returns true if
- the reference to which a points is an instance of class B,
- a subclass of B (directly or indirectly),
- or a class that implements the B interface (directly or indirectly).

 */
public class UsingInstanceof {

    public static void main(String ... args) {
        HeavyAnimal hippo = new Hippo();
        boolean b1 = hippo instanceof Hippo; // true
        // you see that hippo is an instance of itself. We’d certainly hope so!
        /*
        You see that Hippo is a subclass of HeavyAnimal but not Elephant.
         */
        boolean b2 = hippo instanceof HeavyAnimal; // true
        // returns true because hippo is an instance of its superclass.
        boolean b3 = hippo instanceof Elephant; // false
        /*
        returns false because hippo is not an Elephant. The variable reference is HeavyAnimal, so there could
        be an Elephant in there. At runtime, Java knows that the variable is in fact pointing to
        a Hippo.
         */

        /*
        All Java classes inherit from Object, which means that x instanceof Object is usually true,
            except for one case where it is false.
        If the literal null or a variable reference pointing to null is used to check instanceof,
            the result is false. null is not an Object.
         */

        boolean b4 = hippo instanceof Object; // true
        // returns true because Hippo extends from Object indirectly as do all classes.
        Hippo nullHippo = null;
        boolean b5 = nullHippo instanceof Object; // false
        // returns false because the nullHippo variable reference points to null and null is not a Hippo.

        Hippo anotherHippo = new Hippo();
        //b5 = anotherHippo instanceof Elephant; // DOES NOT COMPILE
        // Error: java: incompatible types: no.book.chapter1AdvancedClassDesign.usinginstanceof.Hippo
        // cannot be converted to no.book.chapter1AdvancedClassDesign.usinginstanceof.Elephant

        /*
        The compiler knows that there is no possible way for a Hippo variable reference to be an Elephant,
            since Hippo doesn’t extend Elephant directly or indirectly.
        The compilation check only applies when instanceof is called on a class.
        When checking whether an object is an instanceof an interface, Java waits until runtime to do the check.
        The reason is that a subclass could implement that interface and the compiler wouldn’t know it.
        There is no way for Hippo to be a subclass of Elephant.
         */

        boolean b6 = hippo instanceof Mother;

        /*
        It so happens that Hippo does not implement Mother. The compiler allows the statement
        because there could later be a class such as this:
                                        class MotherHippo extends Hippo implements Mother { }

        The compiler knows an interface could be added, so the instanceof statement could be true for some subclasses,
            whereas there is no possible way to turn a Hippo into an Elephant.
        The instanceof operator is commonly used to determine if an instance is a subclass of
            a particular object before applying an explicit cast.
         */


    }


    /*
    you needed to know if the animal was an instance of each subclass before applying the cast
        and calling the appropriate method.

    For example, a Bird or Lion probably will not have an addHay() method,
        a Cow or Lion probably will not have an addSeed() method,
        and so on.

    The else throwing an exception is common. It allows the code to fail when an unexpected Animal is passed in.
    This is a good thing. It tells the programmer to fix the code rather than quietly letting the new animal go hungry.

    This is not a good way to write code. instanceof and the practice of casting with if statements is
        extremely rare outside of the exam. It is mostly used when writing a library that will be
        used by many others.
     */
    public void feedAnimal(Animal animal) {

        if(animal instanceof Cow) {
            ((Cow)animal).addHay();
        } else if(animal instanceof Bird) {
            ((Bird)animal).addSeed();
        } else if(animal instanceof Lion) {
            ((Lion)animal).addMeat();
        } else {
            throw new RuntimeException("Unsupported animal");
        }

    }

}
