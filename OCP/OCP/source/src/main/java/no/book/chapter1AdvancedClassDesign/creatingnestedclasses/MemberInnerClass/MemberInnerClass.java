package no.book.chapter1AdvancedClassDesign.creatingnestedclasses.MemberInnerClass;

public class MemberInnerClass {

    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        A.B.C c = b.new C();
        c.allTheX();
    }

}



