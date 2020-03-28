package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.reviewquestions.q13;

public class IsItFurry {

    static interface Mammal { }
    static class Furry implements Mammal { }
    static class Chipmunk extends Furry { }
    public static void main(String[] args) {
        Chipmunk c = new Chipmunk();
        Mammal m = c;
        Furry f = c;
        int result = 0;
        if (c instanceof Mammal) result += 1;
        if (c instanceof Furry) result += 2;
        if (null instanceof Chipmunk) result += 4;
        System.out.println(result);
    }

}

/*
Which is a true statement about the following code?

    A. The output is 0.
B. The output is 3.
    C. The output is 7.
        D. c instanceof Mammal does not compile.
        E. c instanceof Furry does not compile.
        F. null instanceof Chipmunk does not compile.

ANSWER
B.
c is an instance of Chipmunk.
It is an instance of any superclasses or interfaces it implements.
In this case,
    those are Furry, Mammal, and Object.
    null is not an instance of any type.
Therefore, the first two if statements execute and result is 3.
 */