package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.introducingfunctionalprogramming;

/*
The first interface, Run, defines no new methods,
    but since it extends Sprint, which defines a single abstract method,
    it is also a functional interface.
 */
@FunctionalInterface
public interface Run extends Sprint {
}
