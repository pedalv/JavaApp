package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.introducingfunctionalprogramming;

/*
The third interface, Skip, extends Sprint
    and defines a static method
    and a default method, each with an implementation.
Since neither of these methods is abstract, the resulting
    interface has only one abstract method and is a functional interface.
 */
@FunctionalInterface
public interface Skip extends Sprint {
    public default int getHopCount(Kangaroo kangaroo) {return 10;}
    public static void skip(int speed) {}
}
