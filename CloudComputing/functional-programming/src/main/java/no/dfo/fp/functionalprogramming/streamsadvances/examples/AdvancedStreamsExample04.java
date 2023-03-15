/*
 * This code is part of the course "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)" for Pluralsight.
 *
 * Copyright (C) 2021 by Jesper de Jong (jesper@jdj-it.com).
 */
package no.dfo.fp.functionalprogramming.streamsadvances.examples;

import no.dfo.fp.functionalprogramming.model.Category;
import no.dfo.fp.functionalprogramming.model.ExampleData;
import no.dfo.fp.functionalprogramming.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedStreamsExample04 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        /*
         public static <T, K, U>
            Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
                                            Function<? super T, ? extends U> valueMapper,
                                            BinaryOperator<U> mergeFunction) {
                return toMap(keyMapper, valueMapper, mergeFunction, HashMap::new);
            }
         */
        //IMPORTANT****************************************
        // Using Collectors.toMap() to compute the total price of products per category.
        Map<Category, BigDecimal> totalPerCategory = products.stream()
                .collect(Collectors.toMap(
                        Product::getCategory,   // Key mapper function
                        Product::getPrice,      // Value mapper function
                        BigDecimal::add));      // Merge function
        System.out.println(totalPerCategory);   // {OFFICE=25.25, UTENSILS=56.49, FOOD=45.50, CLEANING=12.16}
    }
}
