package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.creatingnestedclasses.memberinnerclass;

public class MemberInnerClass {

    public static void main(String[] args) {

        ABCInnerClasses();

        outer();

        caseOfThePrivateInterface();

    }

    private static void ABCInnerClasses() {
        A a = new A();
        A.B b = a.new B();
        A.B.C c = b.new C();
        c.allTheX();
    }

    private static void caseOfThePrivateInterface() {
        CaseOfThePrivateInterface caseOfThePrivateInterface = new CaseOfThePrivateInterface();
        caseOfThePrivateInterface.new DontTell().shh();
    }

    private static void outer() {
        Outer outer = new Outer();
        outer.callInner();
    }

}
