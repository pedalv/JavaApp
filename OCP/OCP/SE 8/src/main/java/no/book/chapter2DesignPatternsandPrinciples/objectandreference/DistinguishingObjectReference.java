package no.book.chapter2DesignPatternsandPrinciples.objectandreference;

/*
In Java, all objects are accessed by reference, so as a developer you never have direct access
    to the memory of the object itself.
Conceptually, though, you should consider the object
    as the entity that exists in memory,
    allocated by the Java runtime environment.
Regardless of the type of the reference that you have for the object in memory,
    the object itself doesn’t change.
For example, since all objects inherit java.lang.Object,
    they can all be reassigned to java.lang.Object, as shown in the following example:
 */
public class DistinguishingObjectReference {

    public static void main(String ... args) {

        Lemur lemur = new Lemur(); // Object - Lemur lemur, Reference - lemur
        Object lemurAsObject = lemur; // Object lemurAsObject, Reference - lemurAsObject

        /*
        Even though the Lemur object (Lemur lemur) has been assigned a reference with a different type,
            (lemurAsObject) the object itself (Lemur lemur) has not changed
            and still exists as a Lemur object in memory.
        What has changed, then, is our ability to access methods within the Lemur class with the
            lemurAsObject reference. // IMPORTANT IMPORTANT IMPORTANT
        Without an explicit cast back to Lemur, as you’ll see in the next
            section, we no longer have access to the Lemur properties of the object. // IMPORTANT IMPORTANT IMPORTANT

            HasTail reference - hasTail => age = 10
            Lemur reference - lemur => hasHair()
            Primate reference - primate => isTailStriped()
            Lemur object in memory  => age = 10 ___ hasHair() ____ isTailStriped()

        We can summarize this principle with the following two rules:
        1. The type of the object determines which properties exist within the object in memory.
        2. The type of the reference to the object determines which methods and variables are
            accessible to the Java program.

        It therefore follows that successfully changing a reference of an object to a new reference
            type may give you access to new properties of the object,
            but those properties existed before the reference change occurred.
         */

    }

}
