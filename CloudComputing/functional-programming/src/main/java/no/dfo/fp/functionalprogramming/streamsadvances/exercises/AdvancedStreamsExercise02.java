package no.dfo.fp.functionalprogramming.streamsadvances.exercises;

import no.dfo.fp.functionalprogramming.functionreactive.funint.TriFunction;
import no.dfo.fp.functionalprogramming.model.Category;
import no.dfo.fp.functionalprogramming.model.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
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

        int i = adder()
                .apply(2)
                .andThen(adder().apply(10))
                .andThen(adder().apply(5))
                .apply(2);

        List<String> names = Stream.of("iioo", "hjhjhj", "jkkj").collect(toList());
        System.out.println("-----------");
        final String v = "i";
        final Predicate<String> predicateI = s->s.contains(v);
        names
                .stream()
                .filter(n -> n.contains("i"))
                .filter(predicateI)
                //.filter(predicateG)
                .filter(funPredicateadder().apply("i"))
                .filter(funPredicateadder().apply("o"))
                //.forEach(System.out::println);
                .forEach(println);
        System.out.println("-----------"); //iioo

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


        int result = Optional.of(0)
                .map(this::plusOne)
                .map(this::plusOne)
                .map(this::plusOne)
                .get();

    }

    private <U> int plusOne(Integer integer) {
        return integer + 1;
    }

    public static Function<Integer, Function<Integer, Integer>> adder() {
        return x -> y -> x + y;
    }

    public static Function<String, Predicate<String>> funPredicateadder() {
        return str -> (String s) -> s.contains(str);
    }

    static <A, B, R> Function<
            BiFunction<A, B, R>,
            Function<A, Function<B, R>>> curryBiFunction() {
        return (func) -> a -> b -> func.apply(a,b);
    }

    static <A, B, C, R> Function<
            TriFunction<A, B, C, R>,
            Function<A, Function<B, Function<C, R>>>> curryTriFunction() {
        return (func) -> a -> b -> c -> func.apply(a,b, c);
    }

    static <A, B, R> Function<
            Function<A, Function<B, R>>,
            BiFunction<A, B, R>> unCurryBiFunction() {
        return (func) -> (a,b) -> func.apply(a).apply(b);
    }

    static <A, B, C, R> Function<
            Function<A, Function<B, Function<C, R>>>,
            TriFunction<A, B, C, R>> unCurryTriFunction() {
        return (func) -> (a,b, c) -> func.apply(a).apply(b).apply(c);
    }

    final Consumer<String> println = System.out::println;

    private void functionalprogrammingexceptions() {

        final int upsA = Stream
                .of("1", "2", "ups", "3")
                // will crash
                .mapToInt( s-> Integer.parseInt(s))
                .sum();

        final int upsB = Stream
                .of("1", "2", "ups", "3")
                .mapToInt( s-> {
                    try {
                        return  Integer.parseInt(s);
                    } catch(NumberFormatException e) {
                        e.printStackTrace();
                        return 0; //works only for sum
                    }
                })
                .sum();

        final int upsC = Stream
                .of("1", "2", "ups", "3")
                .map( s-> {
                    try {
                        return  Optional.of(Integer.parseInt(s));
                    } catch(NumberFormatException e) {
                        e.printStackTrace();
                        return Optional.<Integer>empty(); //works only for sum
                    }
                })
                .filter(Optional::isPresent)
                .mapToInt(Optional::get)
                .sum();

        final int upsD = Stream
                .of("1", "2", "ups", "3")
                .map( s-> {
                    try {
                        return  Optional.of(Integer.parseInt(s));
                    } catch(NumberFormatException e) {
                        e.printStackTrace();
                        return Optional.<Integer>empty(); //works only for sum
                    }
                })
                .flatMap(Optional::stream)
                .mapToInt(i ->i)
                .sum();

    }

}
