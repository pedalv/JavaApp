package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.implementingpolymorphism;

/*
In this sample code, our Oceanographer class includes a method named checkSound()
    that is capable of accepting any object whose class implements the LivesInOcean interface.
We can also create new objects, such as Fish or Lobster, that also implement the
LivesInOcean interface and that would be compatible with our Oceanographer class.
Polymorphism also allows one object to take on many different forms.
As you may remember from studying for the OCA exam,
    a Java object may be accessed using a reference with the same type as the object,
    a reference that is a superclass of the object,
    or a reference that defines an interface that the object implements,
    either directly or through a superclass.
Furthermore, a cast is not required if the object is being reassigned to a
    supertype or interface of the object.
 */
public class Oceanographer {

    public void checkSound(LivesInOcean animal) {
        animal.makeSound();
    }

    public static void main(String[] args) {
        Oceanographer o = new Oceanographer();
        o.checkSound(new Dolphin());
        o.checkSound(new Whale());

        /*
        This code compiles and executes without issue and yields the following output:
        whistle
        sing
         */
    }


}
