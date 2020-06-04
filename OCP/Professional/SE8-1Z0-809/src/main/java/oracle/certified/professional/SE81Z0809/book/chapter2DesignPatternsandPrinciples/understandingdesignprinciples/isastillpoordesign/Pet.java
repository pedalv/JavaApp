package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.understandingdesignprinciples.isastillpoordesign;

/*
Let’s try to fix the problem by placing Pet and Tiger underneath a Feline parent.
 */
public class Pet extends Feline{
    String name = "";
    int age = 0;

    public void cuddle() { }

}
