package no.dfo.fp.functionalprogramming.streamsbasic.exercises;

import no.dfo.fp.functionalprogramming.model.Product;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BasicStreamsExercise06 {

    /**
     * Exercise 6: Format a list of products into a string, with one product per line.
     *
     * @param products A list of products.
     * @return A string containing the products as strings, separated by newlines ('\n').
     */
    public String formatProductList(List<Product> products) {
        // TODO: Convert each of the products to a string (using Product.toString()) and collect the results in a string.
        // Separate the products strings by a newline character '\n'.
        //
        // Hint: Use the appropriate collector in the last step to convert the product strings into a single string.

        Function<Product, String> priceToMessage = p -> String.format("%s   %s  $   %.2f%n", p.getCategory(), p.getName(), p.getPrice());

        return products
                .stream()
                //.map(p -> p.toString())
                .map(priceToMessage)
                .collect(Collectors.joining());


        //assertThat(exercise.formatProductList(new ArrayList<>(TEST_PRODUCTS)))


//        return products.stream()...;

        //throw new UnsupportedOperationException("Not yet implemented"); // Remove this line
    }
}
