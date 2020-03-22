package no.book.chapter2DesignPatternsandPrinciples.reviewquestions.q10;

public interface CanWalk { // Line 1

    default void walk() { System.out.println("Walking"); }

} // Line 3
