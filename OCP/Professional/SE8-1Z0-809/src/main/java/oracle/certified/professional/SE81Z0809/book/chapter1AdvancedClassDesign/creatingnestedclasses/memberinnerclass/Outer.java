package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.creatingnestedclasses.memberinnerclass;

/*
Member Inner Classes
A member inner class is defined at the member level of a class
(the same level as the methods, instance variables, and constructors).
Member inner classes have the following properties:
■■ Can be declared public, private, or protected or use default access
■■ Can extend any class and implement interfaces
■■ Can be abstract or final
■■ Cannot declare static fields or methods
■■ Can access members of the outer class including private members
The last property is actually pretty cool.
It means that the inner class can access the outer class without doing anything special.
Ready for a complicated way to print “Hi” three times?



.class Files for Inner Classes
Compiling the Outer.java class with which we have been working creates two class files.
Outer.class you should be expecting.
For the inner class, the compiler creates Outer$Inner.class.
You don’t need to know this syntax for the exam.
We mention it so that you aren’t surprised to see files with $ appearing in your directories.
You do need to understand that multiple class files are created.
 */
public class Outer {

    private String greeting = "Hi";

    /*
    A member inner class declaration looks just like a stand‐alone class declaration except
        that it happens to be located inside another class—oh, and that it can use the
        instance variables declared in the outer class.
     */
    protected class Inner {
        public int repeat = 3;

        public void go() {
            for (int i = 0; i < repeat; i++)
                System.out.println(greeting);
                /*
                It shows that the inner class just refers to greeting as if it were available.
                This works because it is in fact available.
                Even though the variable is private, it is within that same class.
                */
        }
    }

    public void callInner() {
        /*
        Since a member inner class is not static, it has to be used with an instance of the outer class.
        It shows that an instance of the outer class can instantiate Inner normally.
        This works because callInner() is an instance method on Outer.
        Both Inner and callInner() are members of Outer.
        Since they are peers, they just write the name.
         */
        Inner inner = new Inner();
        inner.go();


        /*
        There is another way to instantiate Inner that looks odd at first.
        OK, well maybe not just at first.
        This syntax isn’t used often enough to get used to it:
         */
        Outer outer = new Outer();
        inner = outer.new Inner(); // create the inner class
        /*
        Let’s take a closer look at it.
        We need an instance of Outer in order to create Inner.
        We can’t just call new Inner() because Java won’t know with which instance of Outer it is associated.
        Java solves this by calling new as if it were a method on the outer variable.
         */
        inner.go();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.callInner();
    }

}
