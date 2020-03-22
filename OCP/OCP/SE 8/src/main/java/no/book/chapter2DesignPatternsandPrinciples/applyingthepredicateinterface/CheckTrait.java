package no.book.chapter2DesignPatternsandPrinciples.applyingthepredicateinterface;

@FunctionalInterface
public interface CheckTrait {

    /*
    You can imagine that we’d have to create lots of interfaces like this to use lambdas.
    We want to test animals, plants, String values, and just about anything else that we come across.
     */
    public boolean test123(Animal a);

}
