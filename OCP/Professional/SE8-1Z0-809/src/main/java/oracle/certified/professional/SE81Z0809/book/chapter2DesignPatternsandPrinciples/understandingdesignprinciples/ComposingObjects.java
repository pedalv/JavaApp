package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.understandingdesignprinciples;

/*
In object‐oriented design, we refer to object composition as the property of constructing a class
    using references to other classes in order to reuse the functionality of the other classes.
In particular, the class contains the other classes in the has‐a sense
    and may delegate methods to the other classes.
Object composition should be thought of as an alternate to inheritance and is often used
    to simulate polymorphic behavior that cannot be achieved via single inheritance.
 */
public class ComposingObjects {

}

class Flippers {
    public void flap() {
        System.out.println("The flippers flap back and forth");
    }
}

class WebbedFeet {
    public void kick() {
        System.out.println("The webbed feet kick to and fro");
    }
}

/*
Trying to relate these objects using inheritance does not make sense,
    as WebbedFeet are not the same as Flippers.
Instead, we can compose a new class that contains both of these
    objects and delegates its methods to them.
 */

class Penguin {
    private final Flippers flippers;
    private final WebbedFeet webbedFeet;

    public Penguin() {
        this.flippers = new Flippers();
        this.webbedFeet = new WebbedFeet();
    }
    public void flap() {
        this.flippers.flap();
    }
    public void kick() {
        this.webbedFeet.kick();
    }
}

/*
As you can see, this new class Penguin is composed of instances of Flippers and WebbedFeet.
Furthermore, the heavy lifting of flap() and kick() is delegated to the other classes,
    with the methods in the Penguin class being only one line long.
Note that implementations of these methods in the delegate classes are also only one line long,
    although they could conceivably be much more complex.
One of the advantages of object composition over inheritance is that it tends to promote greater code reuse.
By using object composition, you gain access to other classes and
methods that would be difficult to obtain via Java’s single‐inheritance model.

In our previous example, the Flippers class can be reused in classes completely
    unrelated to a Penguin or a Bird, such as in a Dolphin or Turtle class.

Alternatively, if the Flippers class had been inherited from the Penguin class, then using it in other
    unrelated classes would be difficult without breaking the class model or having the other
    class contain an instance of a Penguin.

For example, it would be silly to say a Dolphin is inherited from a Penguin or has an instance of a Penguin class,
    just because a Dolphin has Flippers, and Flippers inherits from the Penguin class.

RESUME
Object composition may seem more attractive than inheritance because of its reusable nature,
    but bear in mind that one of the strengths of Java is its powerful inheritance model.
Object composition still requires you to explicitly expose the underlying methods and values manually,
    whereas inheritance includes protected and public members automatically.
Also, using method overloading to determine dynamically which method to select at runtime
    is an extremely powerful tool for building intelligent classes.
In other words, both object composition and inheritance have their proper place in developing good code,
    and in many cases it may be difficult to decide which path to choose.


 */




