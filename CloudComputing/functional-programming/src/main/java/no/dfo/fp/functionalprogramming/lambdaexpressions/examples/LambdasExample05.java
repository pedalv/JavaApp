/*
 * This code is part of the course "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)" for Pluralsight.
 *
 * Copyright (C) 2021 by Jesper de Jong (jesper@jdj-it.com).
 */
package no.dfo.fp.functionalprogramming.lambdaexpressions.examples;

import no.dfo.fp.functionalprogramming.lambdaexpressions.model.ExampleData;
import no.dfo.fp.functionalprogramming.lambdaexpressions.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdasExample05 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        BigDecimal priceLimit = new BigDecimal("5.00");

        List<Product> cheapProducts = new ArrayList<>();

        // BAD PRACTICE! Modifying cheapProducts inside the body of the lambda expression.
        // In general, avoid side effects such as modifying objects from captured variables in lambda expressions.
        products.forEach(product -> {
            if (product.getPrice().compareTo(priceLimit) < 0) {
                cheapProducts.add(product);
            }
        });


        //BAD Example - Solution streams do not have site affects
        // The application can crash with ConcurrentModificationException because multiple threats
        //try to change priceLimit
        products.stream().parallel().forEach(product -> {
            if (product.getPrice().compareTo(priceLimit) < 0) {
                cheapProducts.add(product);
            }
        });
        products.parallelStream().forEach(product -> {
            if (product.getPrice().compareTo(priceLimit) < 0) {
                cheapProducts.add(product);
            }
        });

        products.stream().parallel().collect(Collectors.toList());



        // Print the cheap products.
        cheapProducts.forEach(product -> System.out.println(product));
    }
}
