/*
 * This code is part of the course "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)" for Pluralsight.
 *
 * Copyright (C) 2021 by Jesper de Jong (jesper@jdj-it.com).
 */
package no.dfo.fp.functionalprogramming.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    private final Category category;
    private final String name;
    private final BigDecimal price;
/*
    public Product(Category category, String name, BigDecimal price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%-10s %-16s $ %6.2f", category, name, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return category == product.category && name.equals(product.name) && price.equals(product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, name, price);
    }

 */
}
