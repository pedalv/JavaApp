package oracle.certified.associate.SE81Z0803.test4;

/**
 * Created by pedro alves on 08/03/15.
 */
public class Q47 {
}

class A{}
class B extends A {}
class C extends B {}


class X {
    B getB() { return new B();}
}

class Y extends X {

    //A.
    //public C getB() {return new B();}
    //NOT
    // Since B is NOT a C, this will not compile
    // Its return type is specofied as C,
    // but it is actually returning an object of type B

    //B.
    //protected B getB() {return new C();}
    //OKAY
    // Since C is-a B, this is valid
    // An overrifing method can be made
    // less restrictive
    // protected is less restrictive than
    // "default" access
    // public < protected < package (deafult) < private
    // public is less restrictive
    // private is most restrictive

    //C getB() {return new C();}
    // OKAY
    // here, C is a subclass of B, so this is valid
    // Covariant returns are allowed in java 1.5,
    // which means tha an overriding method can change
    // the return type of the overridden method to a
    // subclass of the original return type

    //A getB() {return new A();}
    // An overriding method cannot return a superclass
    // object of the return type defined in the
    // overridden method.
    // A subclass is allowed in java 1.5
    // so it is allowed:
    // 1. C getB() {return new C();}
    // 2. B getB() {return new C();}
    // 3. B getB() {return new B();}

}


