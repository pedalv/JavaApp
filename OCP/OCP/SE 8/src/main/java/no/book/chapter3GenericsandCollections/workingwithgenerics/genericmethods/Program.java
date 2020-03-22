package no.book.chapter3GenericsandCollections.workingwithgenerics.genericmethods;

public class Program {

    public static void main (String ... args) {

        GenericMethods.<String>ship("package");
        GenericMethods.<String[]>ship(args);

    }

}
