package oracle.certified.professional.SE81Z0809.book.chapter2DesignPatternsandPrinciples.introducingfunctionalprogramming;

/*
In this example, the Sprint class is a functional interface,
    because it contains exactly one abstract method,
    and the Tiger class is a valid class that implements the interface.
 */
public class Tiger implements Sprint {

    @Override
    public void sprint(Animal animal) {
        System.out.println("Animal is sprinting fast! "+animal.toString());
    }

}
