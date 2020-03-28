package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.introducingfunctionalprogramming;


/*
Error: java: Unexpected @FunctionalInterface annotation
  no.book.chapter2DesignPatternsandPrinciples.introducingfunctionalprogramming.Dance is not a functional interface
    multiple non-overriding abstract methods found in interface no.book.chapter2DesignPatternsandPrinciples.introducingfunctionalprogramming.Dance

The Dance method extends Sprint,
    which already includes a single abstract method,
    bringing the total to two abstract methods;
    therefore, Dance is not a functional interface.
 */
//@FunctionalInterface
public interface Dance extends Sprint {
    public void dance(Animal animal);
}
