package oracle.certified.associate.SE81Z0803.test3;

/**
 * Created by pedro alves on 01/03/15.
 */
public class Q64 {

}


abstract class TestClassAbs{
    /*
    Any class can be declared abstract even if it does not
    have any abstract method
     */
    transient int j;
    /*
    The transient keyword in Java is used to indicate that
    a field should not be serialized.

    From the Java Language Specification,
    Java SE 7 Edition, Section 8.3.1.3. transient Fields:

    Variables may be marked transient to indicate that
    they are not part of the persistent state of an object.
     */
    //synchronized int k;
    /*
    modifier synchronizer not allowed here because variables
    cannot be declared synchronized.

    only methods can be declared synchronized.
     */
    int k;
    final void TestClassAbs(){}
    /*
    It is not a constructor, it is a simple method.

    Notice void return type.

    Constructors are not inherited, and so it doesn´t make
    sense to mark them as final.  So there is no question
    of overriding them.
     */
    //static void f() {k = j++;}
    /*
    Because it refers to instance variables j and k

    Static methods cannot refer to non-static/instance members
    (this includes fields and methods)
     */
    void f() {k = j++;}


    //native int t;
    // abstract int t;
    /*
    variable cannot be declared abstract and native
     */


    /*
    1.static and final
    are valid modifiers for both member field and method
    declarations within a class

    2. transient and volatile modifiers
    are only valid for member field declarations

    3. abstract and natide
    are only valid for member methods

    Note
    1. a class declaration can have only
    final, abstract and public as modifiers,
    unless it is a nested class,
    in which case,
    it can be declared private or protected as well
    2. within a method,
    a local variable may be declared as final

     */
}