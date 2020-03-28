package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.creatingnestedclasses;

import oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.creatingnestedclasses.anonymousinnerclasses.*;
import oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.creatingnestedclasses.localinnerclasses.FinalVariable;
import oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.creatingnestedclasses.localinnerclasses.Outer;

/*
A nested class is a class that is defined within another class.
A nested class that is not static is called an inner class.
There are four of types of nested classes:
■■ A member inner class is a class defined at the same level as instance variables.
    It is not static.
    Often, this is just referred to as an inner class without explicitly saying the type.
■■ A local inner class is defined within a method.
■■ An anonymous inner class is a special case of a local inner class that does not have a name.
■■ A static nested class is a static class that is defined at the same level as static variables.

There are a few benefits of using inner classes.
They can encapsulate helper classes by restricting them to the containing class.
They can make it easy to create a class that will be used in only one place.
They can make the code easier to read.
They can also make the code harder to read when used improperly.
 */
public class NestedClassesProgram {

    /*
    There are four of types of nested classes:
    ■■ 1. A member inner class
    ■■ 2. A local inner class
    ■■ 3. An anonymous inner class
    ■■ 4. A static nested class
     */

    public static void main(String ... args) {

        localInnerClasses();

        anonymousInnerClasses();

        memberInnerClass();
    }

    private static void memberInnerClass() {
       /*
        Error:(52, 10) java: no.book.chapter1AdvancedClassDesign.creatingnestedclasses.memberinnerclass.A.B
            is not public in no.book.chapter1AdvancedClassDesign.creatingnestedclasses.memberinnerclass.A;
            cannot be accessed from outside package
        Error:(52, 23) java: no.book.chapter1AdvancedClassDesign.creatingnestedclasses.memberinnerclass.A.B
            is not public in no.book.chapter1AdvancedClassDesign.creatingnestedclasses.memberinnerclass.A;
            cannot be accessed from outside package
        Error:(53, 10) java: no.book.chapter1AdvancedClassDesign.creatingnestedclasses.memberinnerclass.A.B
            is not public in no.book.chapter1AdvancedClassDesign.creatingnestedclasses.memberinnerclass.A;
            cannot be accessed from outside package
        TODO: Need change classes B and C  from default to public to work

        A a = new A();
        A.B b = a.new B();
        A.B.C c = b.new C();
        c.allTheX();
        */

       /*
       Error: java: no.book.chapter1AdvancedClassDesign.creatingnestedclasses.memberinnerclass.CaseOfThePrivateInterface.DontTell
        is not public in no.book.chapter1AdvancedClassDesign.creatingnestedclasses.memberinnerclass.CaseOfThePrivateInterface;
        cannot be accessed from outside package

       CaseOfThePrivateInterface caseOfThePrivateInterface = new CaseOfThePrivateInterface();
       caseOfThePrivateInterface.new DontTell().shh();
        */

        oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.creatingnestedclasses.memberinnerclass.Outer outer = new oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.creatingnestedclasses.memberinnerclass.Outer();
       outer.callInner();
    }

    private static void anonymousInnerClasses() {
        AnonInnerA anonInnerA = new AnonInnerA();
        int baseprise = 99;
        int admission = anonInnerA.admission(baseprise);
        System.out.println("abstract class SaleTodayOnly --> baseprise: " + baseprise + ", admission: " + admission);

        AnonInnerI anonInnerI = new AnonInnerI();
        admission = anonInnerI.admission(baseprise);
        System.out.println("interface SaleTodayOnly --> baseprise: " + baseprise + ", admission: " + admission);

        AnonInnerIs anonInner2Is = new AnonInnerIs();
        String admissionI = anonInner2Is.admission(baseprise);
        System.out.println("interface SaleTodayOnly extends Pedro --> " + admissionI);

        AnonInnerAI anonInner2AI = new AnonInnerAI();
        admissionI = anonInner2AI.admission(baseprise);
        System.out.println("abstract class SaleTodayOnly implements Pedro --> " + admissionI);

        AnonInnerAIC anonInnerAIC = new AnonInnerAIC();
        admissionI = anonInnerAIC.admission(baseprise);
        System.out.println("abstract class SaleTodayOnly extends Pedro2 implements Pedro --> " + admissionI);

        AnonInnerAICsolution anonInnerAICsolution = new AnonInnerAICsolution();
        admission = anonInnerAICsolution.pay();
        System.out.println("interface SaleTodayOnly (Solution) --> baseprise: " + baseprise + ", admission: " + admission);

    }

    private static void localInnerClasses() {
        FinalVariable fvar = new FinalVariable();
        fvar.isItFinal();

        Outer outer = new Outer();
        outer.calculate();
    }

}
