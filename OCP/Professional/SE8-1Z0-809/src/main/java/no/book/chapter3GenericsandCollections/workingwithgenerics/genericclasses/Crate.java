package no.book.chapter3GenericsandCollections.workingwithgenerics.genericclasses;

import no.book.chapter1AdvancedClassDesign.usinginstanceof.Elephant;

/*
You can introduce generics into your own classes.
The syntax for introducing a generic is to declare a formal type parameter in angle brackets.

The generic type T is available anywhere within the Crate class.
When you instantiate the class, you tell the compiler what T should be for that particular instance.

 */
public class Crate<T> {
    private T contents;

    public T emptyCrate() {
        return contents;
    }

    public void packCrate(T contents) {
        this.contents = contents;
    }
}

/*
Naming Conventions for Generics

A type parameter can be named anything you want.
The convention is to use single uppercase letters to make it obvious that they aren’t real class names.
The following are common letters to use:
■■ E for an element
■■ K for a map key
■■ V for a map value
■■ N for a number
■■ T for a generic data type
■■ S, U, V, and so forth for multiple generic types
 */


class UseGenerics {
    public static void main(String ... args) {
        /*
        For example,
            suppose an Elephant class exists,
            and we are moving our elephant to a new and larger enclosure in our zoo.
         */
        Elephant elephant = new Elephant();
        Crate<Elephant> crateForElephant = new Crate<>();
        crateForElephant.packCrate(elephant);
        Elephant inNewHome = crateForElephant.emptyCrate();

        /*
        What if we wanted to create a Crate for another animal?
         */
        Crate<Zebra> crateForZebra = new Crate<>();

        /*
        Now we couldn’t have simply hard-coded Elephant in the Crate class,
            since a Zebra is not an Elephant.

        However,
            we could have created an Animal superclass
            or interface
            and used that in Crate.

        Generic classes become useful when
            the classes used as the type parameter
            can have absolutely nothing to do with each other.

        For example,
            we need to ship our 120-pound robot to another city:
         */

        Robot joeBot = new Robot();
        Crate<Robot> robotCrate = new Crate<>();
        robotCrate.packCrate(joeBot);
        // ship to St. Louis
        Robot atDestination = robotCrate.emptyCrate();


        /*
        Now it is starting to get interesting.
        The Crate class works with any type of class.
        Before generics,
            we would have needed Crate
            to use the Object class
            for its instance variable,
            which would have put the burden on the caller of needing
            to cast the object it receives on emptying the crate.
        In addition to Crate
            not needing to know about the objects that go into it,
            those objects don’t need to know about Crate either.
        We aren’t requiring the objects to implement an interface named Crateable
            or the like.
        A class can be put in the Crate without any changes at all.
         */
    }

}
