package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.introducingfunctionalprogramming;

/*
Error: java: Unexpected @FunctionalInterface annotation
  no.book.chapter2DesignPatternsandPrinciples.introducingfunctionalprogramming.Crawl is not a functional interface
    multiple non-overriding abstract methods found in interface no.book.chapter2DesignPatternsandPrinciples.introducingfunctionalprogramming.Crawl
Finally, the Crawl method defines
two abstract methods; therefore it cannot be a functional interface.
 */
//@FunctionalInterface
public interface Crawl {
    public void crawl();
    public int getCount();
}
