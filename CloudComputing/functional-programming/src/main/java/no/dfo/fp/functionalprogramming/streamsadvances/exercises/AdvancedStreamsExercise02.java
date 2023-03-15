package no.dfo.fp.functionalprogramming.streamsadvances.exercises;

import no.dfo.fp.functionalprogramming.model.Category;
import no.dfo.fp.functionalprogramming.model.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class AdvancedStreamsExercise02 {

    /**
     * Exercise 2: Count the number of products per category.
     *
     * @param products A list of products.
     * @return A Map containing categories as keys, and the number of product for each category as values.
     */
    public Map<Category, Long> countProductsPerCategory(List<Product> products) {

        otherSortedImportantSample();

        // TODO: Group the products by category and count the number of products in each category.
        //
        // Hint: Remember how grouping works. It splits the input stream into multiple streams.
        // You can use a downstream collector to process the output streams of the grouping operation further.
        // For counting the number of products, look at the API documentation of class Collectors - there's a factory method that you can use.

        Map<Category, List<Product>> productsbycategory = products
                .stream()
                .collect(groupingBy(Product::getCategory));


        Map<Category, Long> productsbycategorycounting = products
                .stream()
                .collect(groupingBy(Product::getCategory, counting()));

        //******************IMPORTANT*****************
        return products
                .stream()
                .collect(groupingBy(Product::getCategory, counting()));

        //assertThat(exercise.countProductsPerCategory(TestData.getProducts()))


//        return products.stream()...;

        //throw new UnsupportedOperationException("Not yet implemented"); // Remove this line
    }

    //******************IMPORTANT*****************
    private void otherSortedImportantSample() {
        long count = Stream.of(1, 2, 3).collect(counting()); // 3

        Stream.of(1, 2, 3).collect(maxBy(Comparator.naturalOrder())).ifPresent(System.out::println); // 3

        Integer sum =Stream.of(1, 2, 3).collect(summingInt(i -> i)); // 6

        Map<Integer, List<Integer>> mapIntList =
                Stream.of(2, 34, 54, 23, 33, 20, 59, 11, 19, 37)
                        .collect( groupingBy (i -> i/10 * 10 ) ); //{0=[2], 50=[54,59], 20=[23,20], 10=[11,19], 30=[34,33,37]}

        Map<Integer, Long> mapIntLog =
                Stream.of(2, 34, 54, 23, 33, 20, 59, 11, 19, 37)
                        .collect(groupingBy(i -> i/10 * 10, counting())); //{0=1, 50=2, 20=2, 10=2, 30=3}

        Map<Integer, Map<String, List<Integer>>> mapIntMap =
                Stream.of(2,34,54,23,33,20,59,11,19,37)
                        .collect(groupingBy(i -> i/10 * 10, groupingBy(i -> i%2 == 0 ? "EVEN" : "ODD")));

        Map<Integer, Map<String, List<Integer>>> map =
                Stream.of(2,34,54,23,33,20,59,11,19,37)
                        .collect(groupingBy(i -> i/10 * 10, groupingBy(i -> i%2 == 0 ? "EVEN" : "ODD")));

        //RESULT
        map.forEach((k,v)-> System.out.println(String.format("%d = %s", k, v.toString())));
        /*
        {
            0 = {EVEN=[2]},
            50 = {EVEN=[54], ODD=[59]},
            20 = {EVEN=[20], ODD=[23]},
            10 = {ODD=[11, 19]},
            30 = {EVEN=[34], ODD=[33, 37]}
        }
         */
        Map<Integer, Map<String, List<Integer>>> mapsorted =
                Stream.of(2,34,54,23,33,20,59,11,19,37)
                        .collect( groupingBy(i -> i/10 * 10,
                                TreeMap::new,
                                groupingBy(i -> i%2 == 0 ? "EVEN" : "ODD"))
                        );
        //RESULT
        map.forEach((k,v)-> System.out.println(String.format("%d = %s", k, v.toString())));
        /*
        {
            0 = {EVEN=[2]},
            10 = {ODD=[11, 19]},
            20 = {EVEN=[20], ODD=[23]},
            30 = {EVEN=[34], ODD=[33, 37]},
            50 = {EVEN=[54], ODD=[59]}
        }
         */


        Map<Boolean, List<Integer>> mapList =
                Stream.of(45, 9, 65, 77, 12, 89, 31)
                        .collect(partitioningBy(i -> i < 50)); //{false=[65, 77, 89], true=[45, 9, 12, 31, 12]}

        Map<Boolean, Set<Integer>> mapSorted =
                Stream.of(45, 9, 65, 77, 12, 89, 31, 12)
                        .collect(partitioningBy(i -> i < 50, toSet())); //{false=[65, 89, 77], true=[9, 12, 45, 31]}
        Set<Integer> lessThan50 = mapSorted.get(true);
        Set<Integer> moreThan50 = mapSorted.get(false);
    }

}
