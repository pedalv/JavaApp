/*
 * This code is part of the course "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)" for Pluralsight.
 *
 * Copyright (C) 2021 by Jesper de Jong (jesper@jdj-it.com).
 */
package no.dfo.fp.functionalprogramming.lambdaexpressions.exercises;

import no.dfo.fp.functionalprogramming.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LambdasExercise03 {

    public interface ShoppingCartFactory {
        ShoppingCart newShoppingCart();
    }

    /**
     * Exercise 3a: Implement interface ShoppingCartFactory using a method reference.
     *
     * @return A new ShoppingCartFactory.
     */
    public ShoppingCartFactory getShoppingCartFactory() {
        // TODO: Implement interface ShoppingCartFactory by using a method reference
        // Note: Don't implement ShoppingCartFactory with an anonymous class
        //return null; // Replace 'null' by your solution
        return ShoppingCart::new;
    }

    public static class ShoppingCart {
        private final List<Product> products = new ArrayList<>();

        public void add(Product product) {
            this.products.add(product);
        }

        /**
         * Exercise 3b: Calculate the total amount of the items in the shopping cart.
         *
         * @return The total amount of the items in the shopping cart.
         */
        public BigDecimal getTotalAmount() {
            BigDecimal total = BigDecimal.ZERO;

            // TODO: This solution does not work. Can you explain why?
            //products.forEach(product -> total.add(product.getPrice()));
            //because reference is final and it doesn't change and it is "0".


            // TODO: Implement this method in whatever way you like (you don't have to use lambda expressions)
           total = products.stream()
                   .map(p-> p.getPrice())
                   .reduce(total, (sum, p)-> sum.add(p));

            return total;
        }
    }
}
