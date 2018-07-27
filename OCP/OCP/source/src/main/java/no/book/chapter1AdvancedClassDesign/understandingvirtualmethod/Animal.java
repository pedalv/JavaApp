package no.book.chapter1AdvancedClassDesign.understandingvirtualmethod;

abstract class Animal {

    //Method
    public void careFor() {
        play();
    }
    public void play() {
        System.out.println("pet animal");
    }



    //Variable
    String name = "???"; // -----> *** IMPORTANT IMPORTANT IMPORTANT ***

    public void printName() {
        System.out.println(name);
    }




    public abstract void feed();

}
