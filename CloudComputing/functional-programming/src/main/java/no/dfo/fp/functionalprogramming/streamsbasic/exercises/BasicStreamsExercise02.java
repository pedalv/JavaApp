package no.dfo.fp.functionalprogramming.streamsbasic.exercises;

import no.dfo.fp.functionalprogramming.model.Category;
import no.dfo.fp.functionalprogramming.model.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicStreamsExercise02 {

    /**
     * Exercise 2a: In a list of products, find the products that are in a given category and return their names.
     *
     * @param products A list of products.
     * @param category A product category.
     * @return A List containing the names of the products in the given category.
     */
    public List<String> getProductNamesForCategory(List<Product> products, Category category) {
        // TODO: Add three stream operation methods:
        //
        // 1) Find the products that are in the given category
        // 2) Transform each product to its name
        // 3) Collect the result into a List
        //
        // Hint: Use the API documentation of interface java.util.stream.Stream.

        return products
                .stream()
                .filter(product -> product.getCategory().equals(category))
                .map(Product::getName)
                .collect(Collectors.toList());

//        return products.stream()...;

        //       throw new UnsupportedOperationException("Not yet implemented"); // Remove this line
    }

    /**
     * Exercise 2b: Given a map that contains products grouped by category and a stream of categories, get the names of the products
     * for each category in that stream and return all the products in a list.
     *
     * @param productsByCategory A map containing products grouped by category.
     * @param categories         A stream of product categories.
     * @return A list containing the names of products in each of the categories in the given stream.
     */
    public List<String> categoriesToProductNames(Map<Category, List<Product>> productsByCategory, Stream<Category> categories) {
        // TODO: Start with the stream of categories.
        // For each category in that stream, get the products.
        // Then transform them to product names.
        // Finally, collect the results in a list.
        //
        // Hint: You'll need to use different mapping methods.


/*
        //Try 1
        //Can only run one time otherway stream has already been operated upon or closed
        List<String> names = new ArrayList<>();
        categories.forEach( c -> {
            List<Product> p = productsByCategory.get(c);
            List<String> cpn = p.stream()
                    .map(Product::getName)
                    .distinct()
                    .collect(Collectors.toList());
            names.addAll(cpn);
        });
        //return names;
*/

/*
        //Try 2
        //Can only run one time otherway stream has already been operated upon or closed
        List<Stream<String>> a = categories
                .map(c -> productsByCategory.get(c))
                .map(products -> products.stream().map(Product::getName))
                .distinct()
                .collect(Collectors.toList());
*/
        //Final version
        return categories
                .map(c -> productsByCategory.get(c))
                .flatMap(products -> products.stream().map(Product::getName))
                .distinct()
                .collect(Collectors.toList());


//        return categories...;

//        throw new UnsupportedOperationException("Not yet implemented"); // Remove this line
    }
}
