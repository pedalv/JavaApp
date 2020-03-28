package oracle.certified.professional.SE81Z0809.book.chapter3GenericsandCollections.workingwithgenerics.genericclasses;


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

import oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.usinginstanceof.Elephant;

/*
Don’t worry if you can’t think of a use for generic classes of your own.
Unless you are writing a library for others to reuse,
    generics hardly show up in the class definitions you write.
They do show up frequently in the code you call,
    such as the Java Collections Framework.
Generic classes aren’t limited to having a single type parameter.
This class shows two generic parameters:
 */
public class SizeLimitedCrate<T, U> {

    private T contents;
    private U sizeLimit;
    /*
    T represents the type that we are putting in the crate.
    U represents the unit that we are using to measure the maximum size for the crate.
     */

    public SizeLimitedCrate(T contents, U sizeLimit) {
        this.contents = contents;
        this.sizeLimit = sizeLimit;
    }

}


/*
To use this generic class, SizeLimitedCrate<T, U>, we can write the following:
 */
class UseGenerisc {

    public static void main(String ... args) {
        Elephant elephant = new Elephant();
        Integer numPounds = 15_000;
        SizeLimitedCrate<Elephant, Integer> c1 = new SizeLimitedCrate<>(elephant, numPounds);
        /*
        Here we specify that
            the type is Elephant
            and the unit is Integer.
        We also throw in a reminder that
            numeric literals have been able to contain underscores since Java 7.
         */
    }

}

/*
Type Erasure

Specifying a generic type allows the compiler to enforce proper use of the generic type.
For example,
    specifying the generic type of Crate as Robot is like replacing
        the T in the Crate class with Robot.
However,
    this is just for compile time.
Behind the scenes,
    the compiler replaces all references to T in Crate with Object.
In othervwords,
    after the code compiles,
    your generics are actually just Object types.

The Crate class looks like the following:

public class Crate {
    private Object contents;

    public Object emptyCrate() {
        return contents;
    }
    public void packCrate(Object contents) {
        this.contents = contents;
    }
}

This means there is only one class file.
There aren’t different copies for different parameterized types.
(Some other languages work that way.)
This process of removing the generics syntax from your code is referred to as type erasure.
Type erasure allows your code to be compatible with older versions of Java that do not contain generics.
The compiler adds the relevant casts for your code to work with this type of erased class.
For example,
    you type Robot r = crate.emptyCrate();
    and the compiler turns it into Robot r = (Robot) crate.emptyCrate();
 */