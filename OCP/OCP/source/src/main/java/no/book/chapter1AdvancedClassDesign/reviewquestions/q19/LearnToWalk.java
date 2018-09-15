package no.book.chapter1AdvancedClassDesign.reviewquestions.q19;

public class LearnToWalk {

    public void toddle() {}

    class BabyRhino extends LearnToWalk {
        // INSERT CODE HERE


        //public void toddle() {}
        /*
        Error: java: method toddle() is already defined in class
            no.book.chapter1AdvancedClassDesign.reviewquestions.q19.LearnToWalk.BabyRhino
         */

        public void Toddle() {}

        //public final void toddle() {}
        /*
        Error:java: method toddle() is already defined in class
            no.book.chapter1AdvancedClassDesign.reviewquestions.q19.LearnToWalk.BabyRhino
         */

        //public static void toddle() {}
        /*
        Error: java: toddle() in no.book.chapter1AdvancedClassDesign.reviewquestions.q19.LearnToWalk.BabyRhino
            cannot override toddle() in
            no.book.chapter1AdvancedClassDesign.reviewquestions.q19.LearnToWalk
            overriding method is static
         */

        //public void toddle() throws Exception {}
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
B. public void Toddle() {}
C. public final void toddle() {}
D. public static void toddle() {}
E. public void toddle() throws Exception {}
F. public void toddle(boolean fall) {}
 */
