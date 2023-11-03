package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.castingobjectreferences;

public class TrickOne {

    /*
    DesignPrinciples are some basic rules to keep in mind when casting variables:
        ...
        3. The compiler will not allow casts to unrelated types.

        The third rule is important;
            the exam may try to trick you with a cast that the compiler doesn’t allow.

        For example, we were able to cast a Primate reference to a Lemur reference
            as Lemur is a subclass of Primate and therefore related.

        Consider this example:
     */

}

class Bird {}
class Fish {
    public static void main(String[] args) {
        Fish fish = new Fish();
        //Bird bird = (Fish)bird; // DOES NOT COMPILE
        /*
        Error: java: incompatible types:
            no.book.chapter2DesignPatternsandPrinciples.castingobjectreferences.Bird
            cannot be converted to
            no.book.chapter2DesignPatternsandPrinciples.castingobjectreferences.Fish

         In this example,
            the classes Fish and Bird are not related through any class hierarchy;
            therefore, the code will not compile.
         */
    }
}
