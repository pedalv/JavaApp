package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.understandingdesignprinciples;

/*
In object‐oriented design, we often want to test whether an object contains a particular property or value.
We refer to the has‐a relationship as the property of an object having a named data object or primitive as a member.
The has‐a relationship is also known as the object composition test.
 */
public class ApplyingHasaRelationship {

}

/*
In this example, Bird and Beak are both classes with different attributes and values.
While they obviously fail the is‐a test, since a Bird is not a Beak, nor is a Beak a Bird,
they do pass the has‐a test, as a Bird has‐a Beak.

Inheritance goes one step further by allowing us to say that any child of Bird must also have a Beak.
More generally, if a parent has‐a object as a protected or public member,
    then any child of the parent must also have that object as a member.
Note that this does not hold true for private members defined in parent classes,
    because private members are not inherited in Java.

 */

class Bird {
    private Beak beak;
    private Foot rightFoot;
    private Foot leftFoot;

}

class Beak {
    private String color;
    private double length;
}

class Foot {
}

/*
Uncovering Problems with the Data Model Using Is‐a and Has‐a

Sometimes relationships appear to pass the is‐a test but fail when combined with the
has‐a test via inheritance.

For example, take a look at the following code:
 */

class Tail {}
class Primate {
    protected Tail tail;
}
class Monkey extends Primate {
    // Monkey has-a Tail since it is-a Primate
    public static void main(String ... args) {
        Monkey m = new Monkey();
        Tail t = m.tail;
    }
}
class Chimpanzee extends Primate {
    // Chimpanzee has-a Tail since it is-a Primate

    public static void main(String ... args) {
        Chimpanzee c = new Chimpanzee();
        Tail t = c.tail;
    }
}
/*
In this example above, a Monkey is‐a Primate and a Chimpanzee is‐a Primate.
The model also states that a Primate has‐a Tail,
    and through inheritance a Monkey has‐a Tail and a Chimpanzee has‐a Tail.

Unfortunately, chimpanzees do not have tails in the real world,
    so the underlying data model is incorrect.
We saw that the model appeared to be correct when examined individually, but by using inheritance,
    we uncovered a flaw in the data model.
The result is that we should remove the Tail property from the Primate class,
    since not all primates have tails. IMPORTANT IMPORTANT IMPORTANT
    (Method/field in a class (tha is not a superclass) in a different package
 */















