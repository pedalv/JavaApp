package no.dfo.fp.functionalprogramming.streamsadvances.exercises;

import no.dfo.fp.functionalprogramming.model.Category;
import no.dfo.fp.functionalprogramming.model.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

public class AdvancedStreamsExercise04 {

    /**
     * Exercise 4: Split the products into food and non-food products and get their names.
     *
     * @param products A list of products.
     * @return A map containing the names of the food products and the non-food products.
     */
    public Map<Boolean, List<String>> getFoodAndNonFoodProductNames(List<Product> products) {
        // TODO: Partition the products into food and non-food products, and transform them into product names.
        //
        // Return a map where the food product names are under the key 'true' and the non-food product names are under the key 'false'.
        //
        // Hint: How do you map the products to product names after partitioning them?

        Map<Boolean, List<Product>> maptruefalseProducts = products
                .stream()
                .collect(
                        partitioningBy(product -> product.getCategory().compareTo(Category.FOOD) == 0)
                );



        Map<Boolean, List<String>> maptruefalseNames = products
                .stream()
                .collect(Collectors.groupingBy(
                        p -> p.getCategory().compareTo(Category.FOOD) == 0,
                        Collectors.mapping(Product::getName, Collectors.toList())));
        /*
        <R> R collect(Supplier<R> supplier,
                  BiConsumer<R, ? super T> accumulator,
                  BiConsumer<R, R> combiner);

         */

        return products
                .stream()
                .collect(Collectors.groupingBy(
                        p -> p.getCategory().compareTo(Category.FOOD) == 0,
                        Collectors.mapping(Product::getName, Collectors.toList())));


        /*



        .describedAs("Exercise 5: Your solution does not return the correct result.")
        .containsExactlyInAnyOrderEntriesOf(Map.of(
                        true, List.of("Apples", "Spaghetti"),
                        false, List.of("Pencils", "Plates", "Knives", "Forks", "Detergent")));
         */



//        return products.stream()...;

        //throw new UnsupportedOperationException("Not yet implemented"); // Remove this line
    }
}
