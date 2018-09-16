package no.book.chapter2DesignPatternsandPrinciples.reviewquestions.q14;

public class Frog implements CanHop {

    public static void main(String[] args) {
        Frog frogA = new TurtleFrog();
        TurtleFrog frogB = new TurtleFrog();
        //BrazilianHornedFrog frogC = new TurtleFrog();
        /*
        Error: java: incompatible types:
            no.book.chapter2DesignPatternsandPrinciples.reviewquestions.q14.TurtleFrog
            cannot be converted to
            no.book.chapter2DesignPatternsandPrinciples.reviewquestions.q14.BrazilianHornedFrog
         */
        CanHop frogD = new TurtleFrog();
        Object frogE = new TurtleFrog();
        //Long frogF = new TurtleFrog();
        /*
        Error: java: incompatible types:
            no.book.chapter2DesignPatternsandPrinciples.reviewquestions.q14.TurtleFrog
            cannot be converted to java.lang.Long
         */
    }
}

/*
Which of the following statements can be inserted in the blank line
    so that the code will   compile successfully?
(Choose all that apply.)

A. Frog
B. TurtleFrog
    C. BrazilianHornedFrog
D. CanHop
E. Object
    F. Long

ANSWER


 */