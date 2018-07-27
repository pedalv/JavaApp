package no.book.chapter1AdvancedClassDesign.understandingvirtualmethod;

public class Cow extends Animal {

    @Override
    public void feed() {
        addHay();
    }

    private void addHay() { }

}
