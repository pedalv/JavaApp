package no.book.chapter1AdvancedClassDesign.creatingnestedclasses.memberinnerclass;

/*
Member Inner Classes

Inner classes can have the same variable names as outer classes.
There is a special way of calling this to say which class you want to access.
You also aren’t limited to just one inner class.
Please never do this in code you write.
Here is how to nest multiple classes and access a variable with the same name in each:

Yes, this code makes us cringe too.
It has two nested classes.
Line 14 instantiates the outer most one.
Line 15 uses the awkward syntax to instantiate a B.
    Notice the type is A.B.
    We could have written B as the type because that is available at the member level of B.
    Java knows where to look for it.
On line 16, we instantiate a C.
    This time, the A.B.C type is necessary to specify.
    C is too deep for Java to know where to look.
Then line 17 calls a method on c.
Lines 8 and 9 are the type of code that we are used to seeing.
    They refer to the instance variable on the current class—the one declared on line 6 to be precise.
Line 10 uses this in a special way.
    We still want an instance variable.
    But this time we want the one on the B class, which is the variable on line 4.
Line 11 does the same thing for class A, getting the variable from line 2.
 */
public class A {

    private int x = 10;

    class B {
        private int x = 20; // Line 4

        class C {
            private int x = 30; // Line 6

            public void allTheX() {
                System.out.println(x); // 30 // Line 8
                System.out.println(this.x); // 30 // Line 9
                System.out.println(B.this.x); // 20 // Line 10
                System.out.println(A.this.x); // 10 // Line 11
            }
        }
    }

    public static void main(String[] args) {
        A a = new A(); // Line 14
        A.B b = a.new B(); // Line 15
        A.B.C c = b.new C(); // Line 16
        c.allTheX(); // Line 17
    }

}
