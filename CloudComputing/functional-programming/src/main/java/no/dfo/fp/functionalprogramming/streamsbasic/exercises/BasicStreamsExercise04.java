package no.dfo.fp.functionalprogramming.streamsbasic.exercises;

import no.dfo.fp.functionalprogramming.model.Category;
import no.dfo.fp.functionalprogramming.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BasicStreamsExercise04 {

    /**
     * Exercise 4: In a list of products, find the cheapest cleaning product.
     *
     * @param products A list of products.
     * @return An Optional containing the cheapest product in the category CLEANING in the list,
     * or an empty Optional if there is no such product in the list.
     */
    public Optional<Product> findCheapestCleaning(List<Product> products) {
        // TODO: Look for products that are in the category CLEANING and find the cheapest one.
        //
        // Hint: Use a terminal operation to find the cheapest product.
        // Look at the API documentation of interface java.util.stream.Stream, find out which operation would be suitable.

        List<Product> unsorted = products
                .stream()
                .filter(p -> p.getCategory().equals(Category.CLEANING))
                .collect(Collectors.toList());

        List<Product> sortedOK = products
                .stream()
                .filter(p -> p.getCategory().equals(Category.CLEANING))
                .sorted((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()))
                .collect(Collectors.toList());

        return products
                .stream()
                .filter(p -> p.getCategory().equals(Category.CLEANING))
                .sorted((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()))
                .findFirst();



//        return products.stream()...;

        //throw new UnsupportedOperationException("Not yet implemented"); // Remove this line
    }
}
