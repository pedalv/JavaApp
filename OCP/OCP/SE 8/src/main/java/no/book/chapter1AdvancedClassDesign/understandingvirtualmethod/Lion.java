package no.book.chapter1AdvancedClassDesign.understandingvirtualmethod;

public class Lion extends Animal {

    public void play() {
        System.out.println("toss in meat");
    }




    String name = "Leo";

    @Override
    public void feed() {
        addMeat();
    }




    private void addMeat() { }
}
