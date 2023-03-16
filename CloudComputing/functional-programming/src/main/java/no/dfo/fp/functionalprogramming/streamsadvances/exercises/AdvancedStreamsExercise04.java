package no.dfo.fp.functionalprogramming.streamsadvances.exercises;

import no.dfo.fp.functionalprogramming.model.Category;
import no.dfo.fp.functionalprogramming.model.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
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

        //******************IMPORTANT*****************
        Map<Boolean, List<String>> maptruefalseNames = products
                .stream()
                .collect(Collectors
                        .partitioningBy(
                                p -> p.getCategory().compareTo(Category.FOOD) == 0,             //Predicate<? super T> predicate,
                                Collectors.mapping(Product::getName, Collectors.toList()))      //Collector<? super T, A, D> downstream
                );
        /*
        or
                .collect(Collectors
                        .groupingBy(
                                p -> p.getCategory().compareTo(Category.FOOD) == 0,             //Function<? super T, ? extends K> classifier,
                                Collectors.mapping(Product::getName, Collectors.toList()))      //Collector<? super T, A, D> downstream
                );
         */


        /*
        <R> R collect(  Supplier<R> supplier,
                        BiConsumer<R, ? super T> accumulator,
                        BiConsumer<R, R> combiner);

        <R, A> R collect(Collector<? super T, A, R> collector);

        --

        public static <T, K> Collector<T, ?, Map<K, List<T>>>
        groupingBy(Function<? super T, ? extends K> classifier) {
            return groupingBy(classifier, toList());
        }

        public static <T, K, D, A, M extends Map<K, D>>
        Collector<T, ?, M> groupingBy(Function<? super T, ? extends K> classifier, Supplier<M> mapFactory, Collector<? super T, A, D> downstream) { ... }

        --

        public static <T>
        Collector<T, ?, Map<Boolean, List<T>>> partitioningBy(Predicate<? super T> predicate) {
            return partitioningBy(predicate, toList());
        }

        public static <T, D, A>
        Collector<T, ?, Map<Boolean, D>> partitioningBy(Predicate<? super T> predicate, Collector<? super T, A, D> downstream) { ... }

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
