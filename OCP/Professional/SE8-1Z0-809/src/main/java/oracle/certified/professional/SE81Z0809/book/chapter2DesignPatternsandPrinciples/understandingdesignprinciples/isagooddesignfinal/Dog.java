package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.understandingdesignprinciples.isagooddesignfinal;

/*
Our class structure now works and is consistent, but if we add a child Dog to Pet,
    we encounter a problem with the is‐a test.
A Dog is‐a Pet, and a Pet is‐a Feline, but the model implies that a Dog is‐a Feline,
    which obviously is not true.

One solution in this example is to not combine Tiger and Pet in the same model,
    preferring to write duplicate code rather than create inconsistent data.

Another solution might be to use the multi‐inheritance properties of
    interfaces and declare Pet an interface rather than a parent class.

You see in this example that the object model is now correct using the is‐a test.
For example, Cat is‐a Animal, Tiger is‐a Feline, Dog is‐a Animal, and so forth.
Pet is now separate from the class inheritance model, but by using interfaces,
    we preserve the relationship that Cat is‐a Pet and Dog is‐a Pet.
 */
public class Dog extends Animal implements Pet {
    @Override
    public void cuddle() {

    }
}
