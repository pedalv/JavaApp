package no.book.chapter2DesignPatternsandPrinciples.designinganinterface;

public class Eagle implements Fly {

    @Override
    public int getWingSpan() throws Exception {
        return 15;
    }

    @Override
    public void land() {
        System.out.println("Eagle is diving fast");
    }

}
