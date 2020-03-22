package no.book.chapter2DesignPatternsandPrinciples.introducingfunctionalprogramming;

/*
The second interface, SprintFaster, extends Sprint and defines
    an abstract method, but this is an override of the parent sprint() method;
    therefore, the resulting interface has only one abstract method,
    and it is considered a functional interface.
 */
@FunctionalInterface
public interface SprintFaster extends Sprint {
    public void sprint(Animal animal);
}
