package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.reviewquestions.q19;

public class LearnToWalk {

    public void toddle() throws Exception {}

    class BabyRhino extends LearnToWalk {
        // INSERT CODE HERE


        //public void toddle() {} // A overrriding

        public void Toddle() {} // B

        //public final void toddle() {} // C overrriding
        /*
        Error:java: method toddle() is already defined in class
            no.book.chapter1AdvancedClassDesign.reviewquestions.q19.LearnToWalk.BabyRhino
         */

        //public static void toddle() {} // D It is not overrriding
        /*
        Error: java: toddle() in no.book.chapter1AdvancedClassDesign.reviewquestions.q19.LearnToWalk.BabyRhino
            cannot override toddle() in
            no.book.chapter1AdvancedClassDesign.reviewquestions.q19.LearnToWalk
            overriding method is static
         */

        //public void toddle() throws Exception {} // E Overload if no overwrite present
        /*
        Error:java: method toddle() is already defined in class
            no.book.chapter1AdvancedClassDesign.reviewquestions.q19.LearnToWalk.BabyRhino
         */

        public void toddle(boolean fall) {}
    }

}

/*

Which of the following can be inserted to override the superclass method?
(Choose all that apply.)


A. public void toddle() {}
(new method)        B. public void Toddle() {}
    C. public final void toddle() {}
    D. public static void toddle() {}
    E. public void toddle() throws Exception {}
F. public void toddle(boolean fall) {}

ANSWER
A, C ?????????????????????.
An override must have the same method signature.
A and C both do.
F is an overload
because it has a different parameter list. E does not compile because it throws a checked
exception not declared in the superclass.
D compiles but is not an override because it is static.
B has a different method name, so it is not even an overload.


 */
