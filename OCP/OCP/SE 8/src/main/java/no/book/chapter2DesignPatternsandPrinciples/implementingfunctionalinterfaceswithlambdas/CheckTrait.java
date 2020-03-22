package no.book.chapter2DesignPatternsandPrinciples.implementingfunctionalinterfaceswithlambdas;


/*
Let’s start with a simple CheckTrait functional interface,
    which has a single method test(),
    which takes as input an instance of an Animal class.
 */
@FunctionalInterface
public interface CheckTrait {
    public boolean test(Animal a);
}
