package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.reviewquestions.q21;

public class RiverOtter implements Otter {

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

ANSWER
A, C, E.
Remember that @Override means that we are implementing a method from a superclass or interface.
The Object class declares methods with the signatures in Options A and C.
Granted, it is a poor implementation of equals(), but it does compile.
Option E is also correct because the method is declared in Otter.
Option F is incorrect because methods from an interface are always public.
Option B is incorrect because the parameter type does not match the one in Object.
Option D is incorrect because the return type does not match the one in Object.
 */
