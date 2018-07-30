package no.book.chapter1AdvancedClassDesign.creatingnestedclasses.memberinnerclass;

public class CaseOfThePrivateInterface {

    private interface Secret {
        public void shh();
    }

    class DontTell implements Secret {
        public void shh() { }
    }

}
