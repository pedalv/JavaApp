package no.book.chapter2DesignPatternsandPrinciples.implementingpolymorphism;

/*
The most important thing to note about this example is that only one object,
    Lemur, is created and referenced.
The ability of the Lemur object to be passed as an instance of an
    interface it implements, HasTail, as well as an instance of one of its superclasses, Primate,
    is the nature of polymorphism.
If you use a variable to refer to an object, then only the methods or variables that are
part of the variable’s reference type can be called without an explicit cast. // IMPORTANT IMPORTANT IMPORTANT
 */
public class Lemur extends Primate implements HasTail {

    public int age = 10;

    @Override
    public boolean isTailStriped() {
        return false;
    }

    public static void main(String[] args) {
        Lemur lemur = new Lemur();
        System.out.println(lemur.age);
        HasTail hasTail = lemur;
        System.out.println(hasTail.isTailStriped());
        Primate primate = lemur;
        System.out.println(primate.hasHair());
        /*
        This code compiles and executes without issue and yields the following output:
        10
        false
        true
         */

        //System.out.println(hasTail.age); // DOES NOT COMPILE // IMPORTANT IMPORTANT IMPORTANT
        /*
        Error: java: cannot find symbol
          symbol:   variable age
          location: variable hasTail of type no.book.chapter2DesignPatternsandPrinciples.implementingpolymorphism.HasTail
        In this example, the reference hasTail has direct access only to methods defined with
            the HasTail interface; therefore, it doesn’t know that the variable age is part of the object.
        */
        //System.out.println(primate.isTailStriped()); // DOES NOT COMPILE // IMPORTANT IMPORTANT IMPORTANT
        /*
        Error: java: cannot find symbol
          symbol:   method isTailStriped()
          location: variable primate of type no.book.chapter2DesignPatternsandPrinciples.implementingpolymorphism.Primate
        Likewise, the reference primate has access only to methods defined in the Primate class,
            and it doesn’t have direct access to the isTailStriped() method.
        */

   }

}
