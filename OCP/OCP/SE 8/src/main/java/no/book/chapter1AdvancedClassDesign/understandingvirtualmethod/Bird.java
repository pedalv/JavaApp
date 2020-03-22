package no.book.chapter1AdvancedClassDesign.understandingvirtualmethod;

public class Bird extends Animal {

    @Override
    public void feed() {
        addSeed();
    }

    private void addSeed() { }
}
