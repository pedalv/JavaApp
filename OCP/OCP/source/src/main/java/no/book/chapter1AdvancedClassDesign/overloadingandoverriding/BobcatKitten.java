package no.book.chapter1AdvancedClassDesign.overloadingandoverriding;

/*
To review, overloading and overriding happen only when the method name is the same.

Further, overriding occurs only when the method signature is the same.
The method signature is the method name and the parameter list.

For overloading, the method parameters must vary by type and/or number.
When multiple overloaded methods are present, Java looks for the closest match first.
It tries to find the following:
■■ Exact match by type
■■ Matching a superclass type
■■ Converting to a larger primitive type
■■ Converting to an autoboxed type
■■ Varargs

For overriding, the overridden method has a few rules:
■■ The access modifier must be the same or more accessible.
■■ The return type must be the same or a more restrictive type, also known as covariant return types.
■■ If any checked exceptions are thrown, only the same exceptions or subclasses of those
exceptions are allowed to be thrown.

The methods must not be static. (If they are, the method is hidden and not overridden.)
 */
public class BobcatKitten extends Bobcat { //public void findDen() { } FRO; Bobcat

    public void findDen() { }
    // It is an override because it has the same method signature.

    public void findDen(boolean b) { }
    // It is an overloaded method because it has the same method name but a different parameter list.

    public int findden() throws Exception { return 0; }
    // It is not an override or overload because it has a different method name. Remember that Java is case sensitive.

}
