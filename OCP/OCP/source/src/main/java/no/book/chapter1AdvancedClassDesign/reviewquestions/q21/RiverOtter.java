package no.book.chapter1AdvancedClassDesign.reviewquestions.q21;

public class RiverOtter implements Otter{

    @Override public boolean equals(Object o) { return false; }
    //@Override public boolean equals(Otter o) { return false; }
    /*
    Error: java: method does not override or implement a method from a supertype
     */

    @Override public int hashCode() { return 42; }
    //@Override public long hashCode() { return 42; }
    /*
    Error: java: method hashCode() is already defined in class no.book.chapter1AdvancedClassDesign.reviewquestions.q21.RiverOtter
    Error: java: method does not override or implement a method from a supertype

     */

    @Override public void play() { }
    //@Override void play() { }
    /*
    Error:java: method play() is already defined in class no.book.chapter1AdvancedClassDesign.reviewquestions.q21.RiverOtter
    Error: java: play() in no.book.chapter1AdvancedClassDesign.reviewquestions.q21.RiverOtter
        cannot implement play() in no.book.chapter1AdvancedClassDesign.reviewquestions.q21.Otter
        attempting to assign weaker access privileges; was public
     */



}

/*
Which of the following could be inserted to fill in the blank? (Choose all that apply.)

A. @Override public boolean equals(Object o) { return false; }
B. @Override public boolean equals(Otter o) { return false; }
C. @Override public int hashCode() { return 42; }
D. @Override public long hashCode() { return 42; }
E. @Override public void play() { }
F. @Override void play() { }

 */
