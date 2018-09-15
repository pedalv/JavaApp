package no.book.chapter1AdvancedClassDesign.reviewquestions.q12;

public class Browsers {

    static class Browser {
        public void go() {
            System.out.println("Inside Browser");
        }
    }
    
    static class Firefox extends Browser {
        @Override public void go() {
            System.out.println("Inside Firefox");
        }
    }

    static class IE extends Browser {
        @Override public void go() {
            System.out.println("Inside IE");
        }
    }

    public static void main(String[] args) {
        Browser b = new Firefox();
        b.go();

        //IE e = b;
        /*
        Error: java: incompatible types:
            no.book.chapter1AdvancedClassDesign.reviewquestions.q12.Browsers.Browser
            cannot be converted to no.book.chapter1AdvancedClassDesign.reviewquestions.q12.Browsers.IE
         */

        //IE e = (IE) b;
        /*
        Exception in thread "main"
            java.lang.ClassCastException: no.book.chapter1AdvancedClassDesign.reviewquestions.q12.Browsers$Firefox
            cannot be cast to no.book.chapter1AdvancedClassDesign.reviewquestions.q12.Browsers$IE
	        at no.book.chapter1AdvancedClassDesign.reviewquestions.q12.Browsers.main(Browsers.java)

         */
        //e.go();
    }
}

/*
What is the result of the following code?

    A. Inside Browser
    B. Inside Firefox
    C. Inside IE
        D. The code does not compile.
E. A runtime exception is thrown.
 */
