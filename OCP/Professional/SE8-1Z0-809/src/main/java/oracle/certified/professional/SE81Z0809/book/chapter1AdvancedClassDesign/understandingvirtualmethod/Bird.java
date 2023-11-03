package oracle.certified.professional.SE81Z0809.book.chapter1AdvancedClassDesign.understandingvirtualmethod;

public class Bird extends Animal {

    @Override
    public void feed() {
        addSeed();
    }

    private void addSeed() { }
}
