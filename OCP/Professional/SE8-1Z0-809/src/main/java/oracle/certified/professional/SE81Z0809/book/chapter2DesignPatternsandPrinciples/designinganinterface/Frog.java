package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.designinganinterface;

/*
Interfaces also serve to provide limited support for multiple inheritance within the
Java language, as a class may implement multiple interfaces, such as in the following
example:


In this example, the Frog class implements both the Swim and Hop interfaces.
An instance of Frog may be passed to any method that accepts Swim, Hop, Frog, or java.lang.Object
    as an input parameter.
As shown in this example, you can also construct interfaces that have
    neither methods nor class members, traditionally referred to as marker interfaces.

In Chapter 8, “IO,” you will see that the java.io.Serializable interface,
    which contains no methods, is an example of a marker interface.
 */
public class Frog implements Swim, Hop {
}
