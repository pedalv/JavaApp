package no.dfo.fp.functionalprogramming.streamsbasic.exercises;

import no.dfo.fp.functionalprogramming.model.Category;
import no.dfo.fp.functionalprogramming.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BasicStreamsExercise05 {

    /**
     * Exercise 5: Check if all office products in the given list of products cost less than a price limit.
     *
     * @param products   A list of products.
     * @param priceLimit The price limit.
     * @return {@code true} if all products in the category OFFICE in the list cost less than the price limit,
     * {@code false} otherwise.
     */
    public boolean areAllOfficeProductsCheap(List<Product> products, BigDecimal priceLimit) {
        // TODO: Look for products in the category OFFICE. Check if all of them cost less than the price limit.
        //
        // Hint: Use two stream operations; one the find the appropriate products,
        // and another one to check if they all cost less than the price limit.

        //IMPORTANT ************************************'
        Map<Boolean, List<Product>> partitionedProducts = products.stream()
                .collect(Collectors.partitioningBy(product -> product.getPrice().compareTo(priceLimit) < 0));
        System.out.println("Cheap products: ");
        partitionedProducts.get(true).forEach(System.out::println);

        System.out.println("Expensive products: ");
        partitionedProducts.get(false).forEach(System.out::println);

        //IMPORTANT ************************************'
        return products
                .stream()
                .filter(p -> p.getCategory().equals(Category.OFFICE))
                .filter(p -> p.getPrice().compareTo(priceLimit) <= 0)
                .findAny()
                .isPresent();





//        return products.stream()...;

        //throw new UnsupportedOperationException("Not yet implemented"); // Remove this line
    }
}
