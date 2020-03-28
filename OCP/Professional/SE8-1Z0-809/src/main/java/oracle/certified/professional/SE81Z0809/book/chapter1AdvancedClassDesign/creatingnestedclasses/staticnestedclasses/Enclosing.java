package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.creatingnestedclasses.staticnestedclasses;

/*
Static Nested Classes
The final type of nested class is not an inner class.
A static nested class is a static class defined at the member level.
It can be instantiated without an object of the enclosing class, so it can’t access the instance
    variables without an explicit object of the enclosing class.

For example, new OuterClass().var allows access to the instance variable var.

In other words, it is like a regular class except for the following:
■■ The nesting creates a namespace because the enclosing class name must be used to refer to it.
■■ It can be made private or use one of the other access modifiers to encapsulate it.
■■ The enclosing class can refer to the fields and methods of the static nested class.
 */
public class Enclosing {

    static class Nested {

        private int price = 6;

    }

    /*
    Line 6 instantiates the nested class.
    Since the class is static, you do not need an instance of Enclosing in order to use it.
    You are allowed to access private instance variables, which is shown on line 7.
     */
    public static void main(String[] args) {
        Nested nested = new Nested(); // Line 6
        System.out.println(nested.price); // Line 7
    }

}
