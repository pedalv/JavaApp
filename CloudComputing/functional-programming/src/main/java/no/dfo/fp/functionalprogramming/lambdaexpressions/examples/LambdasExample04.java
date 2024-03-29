/*
 * This code is part of the course "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)" for Pluralsight.
 *
 * Copyright (C) 2021 by Jesper de Jong (jesper@jdj-it.com).
 */
package no.dfo.fp.functionalprogramming.lambdaexpressions.examples;

import no.dfo.fp.functionalprogramming.model.ExampleData;
import no.dfo.fp.functionalprogramming.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class LambdasExample04 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        BigDecimal priceLimit = new BigDecimal("5.00");

        int numberOfCheapProducts = 0;

        // Check if there are cheap products.
        for (Product product : products) {
            if (product.getPrice().compareTo(priceLimit) < 0) {
                numberOfCheapProducts++;
            }
        }

        // Because local variables are effectively final, you cannot modify them inside a lambda expression.
//        products.forEach(product -> {
//            if (product.getPrice().compareTo(priceLimit) < 0) {
//                numberOfCheapProducts++; // Error: Variable must be effectively final
//            }
//        });

        System.out.println("There are " + numberOfCheapProducts + " cheap products");


        //This solution is less verbose by streams
        long count = products
                .stream()
                .filter(p -> p.getPrice().compareTo(priceLimit) < 0)
                .count();
        System.out.println(count);


    }
}
