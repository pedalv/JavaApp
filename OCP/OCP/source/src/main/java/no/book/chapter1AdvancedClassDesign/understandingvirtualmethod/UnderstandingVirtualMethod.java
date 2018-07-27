package no.book.chapter1AdvancedClassDesign.understandingvirtualmethod;

/*
The Animal class is abstract, and it requires that any concrete Animal subclass have a feed() method.

The three subclasses that we defined have a one‐line feed() method that delegates to the class‐specific method.

A Bird still gets seed, a Cow still gets hay, and so forth.

Now the method to feed the animals is really easy. We just call feed() and the proper subclass’s version is run.

This approach has a huge advantage. The feedAnimal() method doesn’t need to change when we add a new Animal subclass.
We could have methods to feed the animals all over the code.
Maybe the animals get fed at different times on different days. No matter. feed() still gets called to do the work.


 */
public class UnderstandingVirtualMethod {

    /*
    We’ve just relied on virtual method invocation.
    We actually saw virtual methods on the OCA.
    They are just regular non‐static methods.
    Java looks for an overridden method rather than necessarily using the one
        in the class that the compiler says we have.
    The only thing new about virtual methods on the OCP is that Oracle now calls them virtual methods in
        the objectives. You can simply think of them as methods.
     */
    public void feedAnimal(Animal animal) {
        animal.feed();
    }


    /*
    Notice how this technique is called virtual method invocation.
    Instance variables don’t work this way. -----> *** IMPORTANT IMPORTANT IMPORTANT ***
    In this example, the Animal class refers to name.
    It uses the one in the superclass and not the subclass.
     */
    public static void main(String ... args) {
        Animal animal = new Lion();
        animal.printName();
        /*
        This outputs ???.
        The name declared in Lion would only be used if name was referred to
            from Lion (or a subclass of Lion.)
        But no matter how you call printName(), it will use the Animal’s name, not the Lion’s name.
         */

        Lion lion = new Lion();
        lion.printName();
        // This outputs ???


        animal.careFor();
        /*
        The correct answer is toss in meat. -----> *** IMPORTANT IMPORTANT IMPORTANT ***

        The main method creates a new Lion and calls careFor.
        Since only the Animal superclass has a careFor method, it executes.
        That method calls play.
        Java looks for overridden methods, and it sees that Lion implements play.
        Even though the call is from the Animal class, Java still looks at subclasses, which is good
            because you don’t want to pet a Lion!
         */
    }

}
