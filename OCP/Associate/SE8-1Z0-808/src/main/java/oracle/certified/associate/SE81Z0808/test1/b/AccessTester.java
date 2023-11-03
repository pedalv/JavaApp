package oracle.certified.associate.SE81Z0808.test1.b;

import oracle.certified.associate.SE81Z0808.test1.a.AccessTest;

/**
 * Created by p on 07/02/2017.
 */
public class AccessTester extends AccessTest {

    public static void main (String ... args) {
/*
 However, In the words of Java Language Specification, protected members of a class are accessible outside the package
 only in subclasses of that class, and
 only when they are fields of objects that are being implemented by the code that is accessing them.
  */
        AccessTest ref = new AccessTest();
        ref.d();


        AccessTest ref1 = new AccessTester();
        ref.d();

        AccessTester ref2 = (AccessTester) new AccessTest();
        ref2.d();
        ref2.c();
 /*
        Basically, it implies that a protected member is accessible in the subclass only using a reference
        whose declared type is of the same subclass (or its subclass.).
         */


        AccessTester ref3 = new AccessTester();
        ref3.c();
        ref3.d();

/*
now the declared type of ref (i.e. AcessTester) is the same subclass from which you are trying to access c().
 */



    }



}
