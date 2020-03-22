package no.book.chapter2DesignPatternsandPrinciples.applyingthepredicateinterface;

/*
@FunctionalInterface
public interface CheckTrait {
    You can imagine that we’d have to create lots of interfaces like this to use lambdas.
    We want to test animals, plants, String values, and just about anything else that we come across.
    public boolean test123(Animal a);
    }
*/

/*
Luckily, Java recognizes that this is a common problem and provides such an interface for us.
It’s in the package java.util.function, and the gist of it is as follows:


This is very similar to our original program, except that we wrote it with one less interface. (WHERE!!!!)
*/
public interface Predicate<T> {


    /*
    That looks a lot like our method.
    The only difference is that it uses type T instead of Animal.
    As you may remember from your OCA studies, this is the syntax for an interface
        that uses a generic type.
    The result of using Predicate is that we no longer need our own functional interface.
     */
    public boolean test123(T t);

}
