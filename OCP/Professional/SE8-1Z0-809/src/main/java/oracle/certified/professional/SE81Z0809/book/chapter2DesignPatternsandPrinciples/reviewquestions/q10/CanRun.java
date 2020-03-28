package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.reviewquestions.q10;

public interface CanRun { // Line 4

    public default void walk() { System.out.println("Walking fast"); }
    public abstract void run();

} // Line 7
