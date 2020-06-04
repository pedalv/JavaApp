package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.reviewquestions.q14;

import java.util.ArrayList;

public class IsItFurry {

    static class Chipmunk { }
    public static void main(String[] args) {
        Chipmunk c = new Chipmunk();
        ArrayList <Chipmunk> l = new ArrayList<>();
        Runnable r = new Thread();
        int result = 0;
        if (c instanceof Chipmunk) result += 1;

        //if (l instanceof Chipmunk) result += 2;
        /*
        Error: java: incompatible types:
            java.util.ArrayList<no.book.chapter1AdvancedClassDesign.reviewquestions.q14.IsItFurry.Chipmunk>
            cannot be converted to no.book.chapter1AdvancedClassDesign.reviewquestions.q14.IsItFurry.Chipmunk
         */
        if (r instanceof Chipmunk) result += 4;
        System.out.println(result);
    }

}

/*
Which is a true statement about the following code? (Choose all that apply.)

    A. The code compiles, and the output is 0.
    B. The code compiles, and the output is 3.
    C. The code compiles, and the output is 7.
        D. c instanceof Chipmunk does not compile.
E. l instanceof Chipmunk does not compile.
        F. r instanceof Chipmunk does not compile.

ANSWER
E.
Code involving instanceof does not compile when there is no way for it to evaluate true.
D not only compiles but it is always true.
E does not compile because ArrayList is a concrete class that does not extend Chipmunk.
F does compile because Runnable is an interface.
  In theory, someone could subclass Chipmunk and have the subclass implement Runnable.

 */