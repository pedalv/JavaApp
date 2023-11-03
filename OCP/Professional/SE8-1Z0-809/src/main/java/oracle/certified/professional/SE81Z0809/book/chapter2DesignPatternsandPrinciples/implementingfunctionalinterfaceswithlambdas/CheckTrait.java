package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.implementingfunctionalinterfaceswithlambdas;


/*
Lets start with a simple CheckTrait functional interface,
    which has a single method test(),
    which takes as input an instance of an Animal class.
 */
@FunctionalInterface
public interface CheckTrait {
    public boolean test(Animal a);
}
