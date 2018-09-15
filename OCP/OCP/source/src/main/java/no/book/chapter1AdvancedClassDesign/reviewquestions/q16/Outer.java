package no.book.chapter1AdvancedClassDesign.reviewquestions.q16;

public class Outer {

    class Inner { }
    static class InnerStatic { }
    public static void main(String[] args) {
        // INSERT CODE HERE

        //Inner inA = new Inner();
        /*
        Error: java: non-static variable this cannot be referenced from a static context
         */

        //Inner inB = Outer.new Inner();
        /*
        Error:java: cannot find symbol
          symbol:   variable Outer
          location: class no.book.chapter1AdvancedClassDesign.reviewquestions.q16.Outer
         */

        //Outer.Inner inC = new Outer.Inner();
        /*
        Error: java: non-static variable this cannot be referenced from a static context
         */

        //Outer.Inner inD = new Outer().Inner();
        /*
        Error: java: cannot find symbol
          symbol:   method Inner()
          location: class no.book.chapter1AdvancedClassDesign.reviewquestions.q16.Outer
         */

        Outer.Inner inE = new Outer().new Inner();

        //Outer.Inner inF = Outer.new Inner();
        /*
        Error: java: cannot find symbol
          symbol:   variable Outer
          location: class no.book.chapter1AdvancedClassDesign.reviewquestions.q16.Outer
         */

        class Inner2 extends InnerStatic { }

        InnerStatic innerStatic = new InnerStatic();
        Outer outer = new Outer();

    }

}

/*
Which of the following can be inserted in main?

    A. Inner in = new Inner();
    B. Inner in = Outer.new Inner();
    C. Outer.Inner in = new Outer.Inner();
    D. Outer.Inner in = new Outer().Inner();
E. Outer.Inner in = new Outer().new Inner();
    F. Outer.Inner in = Outer.new Inner();


 */
