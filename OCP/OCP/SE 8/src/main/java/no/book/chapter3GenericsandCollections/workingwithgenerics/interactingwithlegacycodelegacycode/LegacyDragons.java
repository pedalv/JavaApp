package no.book.chapter3GenericsandCollections.workingwithgenerics.interactingwithlegacycodelegacycode;

import java.util.ArrayList;
import java.util.List;

public class LegacyDragons {

    public static void main(String[] args) {
        List unicorns = new ArrayList();
        unicorns.add(new Unicorn());
        printDragons(unicorns);
    }

    private static void printDragons(List<Dragon> dragons) {
        /*
        In this example,
            we get a ClassCastException on a line that is working with a generic list.
        At first,
            this seems odd.
        This is the problem that generics are supposed to solve.
        The difference is that all of the code doesn’t use generics here.
        The main() method calls printDragons() with a raw type.
        Due to type erasure,
            Java doesn’t know this is a problem until runtime,
            when it attempts to cast a Unicorn to a Dragon.
        The cast is tricky because it doesn’t appear in the code.
        With generic types,
            Java writes the casts for us.
        Although Java doesn’t know that there is a problem,
            it does know there might be a problem.
        Java knows that raw types are asking for trouble,
            and it presents a compiler warning for this case.
        A compiler warning is different from a compiler error
            in that all of the code still compiles with a compiler error.
        The compiler warning is Java informing you that you should take a closer look at something.
         */
        /*
        Information:java:
            C:\Space2\JavaApp\OCP\OCP\source\src\main\java\no\book\chapter3GenericsandCollections\workingwithgenerics\interactingwithlegacycodelegacycode\LegacyDragons.java
            uses unchecked or unsafe operations.
        Information:java: Recompile with -Xlint:unchecked for details.
         */
        for (Dragon dragon: dragons) { // ClassCastException
            /*
            Exception in thread "main"
                java.lang.ClassCastException: no.book.chapter3GenericsandCollections.workingwithgenerics.interactingwithlegacycodelegacycode.Unicorn
                cannot be cast to
                no.book.chapter3GenericsandCollections.workingwithgenerics.interactingwithlegacycodelegacycode.Dragon
	            at no.book.chapter3GenericsandCollections.workingwithgenerics.interactingwithlegacycodelegacycode.LegacyDragons.printDragons(LegacyDragons.java:15)
	            at no.book.chapter3GenericsandCollections.workingwithgenerics.interactingwithlegacycodelegacycode.LegacyDragons.main(LegacyDragons.java:11)
             */
            System.out.println(dragon);
        }
    }

}

/*
Compiler Warnings

On the exam,
    you have to identify when a compiler warning will occur.
You will not be expected to know how to run the commands to list the compiler warnings
    or read the output.
In the real world, you will need that skill.
When compiling the LegacyDragon class,
    the compiler warnings look something like this:
/*
$ javac *.java
Note: Some input files use unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
 */
 /*
Information:java:
    C:\Space2\JavaApp\OCP\OCP\source\src\main\java\no\book\chapter3GenericsandCollections\workingwithgenerics\interactingwithlegacycodelegacycode\LegacyDragons.java
    uses unchecked or unsafe operations.
Information:java: Recompile with -Xlint:unchecked for details.
 */
/*
Java is basically telling you that it knows you are using old code
    and asking if you want to know more.
If you pass that flag,
    you get something like the following.
(
The exact messages will depend on your compiler.
For example,
    on some compilers,
    you’ll get a fourth warning where the unicorns object is declared.
)

$ javac -Xlint:unchecked *.java
LegacyDragons.java:9: warning: [unchecked] unchecked call to add(E) as a member
of the raw type List
unicorns.add(new Unicorn());
^
where E is a type-variable:
E extends Object declared in interface List
LegacyDragons.java:11: warning: [unchecked] unchecked method invocation: method
printDragons in class LegacyDragons is applied to given types
printDragons(unicorns);
^
required: List<Dragon>
found: List
LegacyDragons.java:11: warning: [unchecked] unchecked conversion
printDragons(unicorns);
^
required: List<Dragon>
found: List
3 warnings

The messages look a little scary,
    but all Java is trying to tell you is that you should really be using generics.
 */