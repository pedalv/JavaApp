package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.castingobjectreferences;

public class Lemur extends Primate {

    public int age = 10;


    public static void main(String[] args) {
        Lemur lemur = new Lemur();
        System.out.println(lemur.age);
        Primate primate = lemur;
        System.out.println(primate.hasHair());

        //Lemur lemur2 = primate; // DOES NOT COMPILE
        /*
        Error: java: incompatible types:
            no.book.chapter2DesignPatternsandPrinciples.castingobjectreferences.Primate
            cannot be converted to
            no.book.chapter2DesignPatternsandPrinciples.castingobjectreferences.Lemur

        In this example, we first try to convert the primate reference back to a lemur reference,
            lemur2, without an explicit cast.
        The result is that the code will not compile.
        In the second example, though, we explicitly cast the object to a subclass of the object Primate,
            and we gain access to all the methods available to the Lemur class.

        DesignPrinciples are some basic rules to keep in mind when casting variables:
        1. Casting an object from a subclass to a superclass doesn’t require an explicit cast.
        2. Casting an object from a superclass to a subclass requires an explicit cast.
        3. The compiler will not allow casts to unrelated types.

        The third rule is important;
            the exam may try to trick you with a cast that the compiler doesn’t allow.

        4. Even when the code compiles without issue, an exception may be thrown at runtime if
            the object being cast is not actually an instance of that class.
         */
        Lemur lemur3 = (Lemur)primate; // IMPORTANT IMPORTANT IMPORTANT
        System.out.println(lemur3.age);

    }
}
