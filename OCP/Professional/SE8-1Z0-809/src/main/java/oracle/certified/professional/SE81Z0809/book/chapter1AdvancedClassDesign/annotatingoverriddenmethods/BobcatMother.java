package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.annotatingoverriddenmethods;


/*
Java provides a way to indicate explicitly in the code that a method is being overridden.

In Java, when you see code that begins with an @ symbol, it is an annotation.
An annotation is extra information about the program, and it is a type of metadata.
It can be used by the compiler or even at runtime.

The @Override annotation is used to express that you, the programmer, intend for this
    method to override one in a superclass or implement one from an interface.
You don’t traditionally think of implementing an interface as overriding, but it actually is an override.
It so happens that the method being overridden is an abstract one.
 */
public class BobcatMother /* subclass */ extends Bobcat /* superclass */ {

    @Override
    public void findDen() { }

    /*
    @Override tells the compiler that the method findDen() is intended to override another method.
    Java ignores whitespace, which means that it the two lines could be merged into one:
        @Override public void findDen(boolean b) { }
    */

    /*
    @Override // Line 1
    public void findDen(boolean b) { } // // Line 2 // DOES NOT COMPILE
    Error: java: method does not override or implement a method from a supertype

    Line 1 still tells Java the method that line 2 is intended to override another method.
    However, the method on line 2 overloads the method rather than overriding it.
    Java recognizes that this is a broken promise and gives it a compiler error.
    It is useful to have the compiler tell you that you are not actually overriding when you think that you are.
    The problem could be a typo. Or it could be that the superclass or interface changed without your knowledge.
    Either way, it is useful information to know so that you can fix the code.
    It is a great idea to get in the habit of using @Override in order to avoid accidentally overloading a method.

    @Override is allowed only when referencing a method.
    Just as there is no such thing as overriding a field, the annotation cannot be used on a field either.

    Much of the time, you will not see @Override used on the exam when a method is being overridden.
    The exam is testing whether you can recognize an overridden method.

    However, when you see @Override show up on the exam, you must check carefully that
        the method is doing one of three things:
    ■■ Implementing a method from an interface
    ■■ Overriding a superclass method of a class shown in the example
    ■■ Overriding a method declared in Object, such as hashCode, equals, or toString
    To be fair, the third one is a special case of the second.
    It is less obvious. Since the methods aren’t declared on the page in front of you, we mention it specifically.
    Pay attention to the signatures of these three methods in the next sections so that you know the method signatures
        well and can spot where they are overridden.
    */

}
