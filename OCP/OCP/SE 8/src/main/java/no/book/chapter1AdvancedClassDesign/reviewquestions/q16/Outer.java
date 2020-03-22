package no.book.chapter1AdvancedClassDesign.reviewquestions.q16;

public class Outer {

    private int x = 5;

    class Inner {
        public /*static*/ int x = 10; // Line 4
        /*
        Error: java: Illegal static declaration in inner
            class no.book.chapter1AdvancedClassDesign.reviewquestions.q16.Outer.Inner
            modifier 'static' is only allowed in constant variable declarations
         */

        //static int i = 0;
        /*
        Error:java: Illegal static declaration in inner class
            no.book.chapter1AdvancedClassDesign.reviewquestions.q16.Outer.Inner
            modifier 'static' is only allowed in constant variable declarations
         */

        //static public void m() {}
        //public static void m2() {}
        /*
        Error: java: Illegal static declaration in inner
            class no.book.chapter1AdvancedClassDesign.reviewquestions.q16.Outer.Inner
            modifier 'static' is only allowed in constant variable declarations
         */


        /*
        Inner is a member inner Outer class.
        Inner classes are not allowed to contain static methods or static variables. (above)
        Only nested static classes are permitted to contain statics. (down)
         */

    }


    static class InnerStatic {

        static int i = 0;
        static public void m() {}
        public static void m2() {}

    }



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

ANSWER
E.
This is a member inner class.
It needs to be created using an instance of the outer class.
The syntax looks weird,
    but it creates an object of the outer class
    and then an object of the inner class from it.

 */
