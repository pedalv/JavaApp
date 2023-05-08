package no.dfo.whatsnewinjava.langandlib;

import java.util.Set;
import java.util.stream.Stream;

/**
 * A module has a name, it
 * groups related code and is
 * self-container
 *
 * Migrating a Classpath-based Application
 * javac -cp $CLASSPATH ...
 * java -cp $CLASSPATH ...
 *
 *
 * Unless ...
 * 1. You use JDK types that have been encapsulated
 * 2. You use types from non-default Java modules
 */
public class Book {

    public final String title;
    public final Set<String> authors;
    public final double price;

    public Book(String title, Set<String> authors, double price) {
        this.title = title;
        this.authors = authors;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    public static Stream<Book> getBooks() {
        return Stream.of(new Book("Java 9 Modularity", Set.of("Sander Mak", "Paul Bakker"), 33.99),
                         new Book("Designing Data-Intensive Applications", Set.of("Martin Klepmann"), 38.99),
                         new Book("Java 8 Lambdas", Set.of("Richard Warburton"), 33.99));
    }

    public static Book getBook() {
        return getBooks().findFirst().get();
    }
}
