package no.dfo.fp.functionalprogramming.streamslambdas.exercises;


import no.dfo.fp.functionalprogramming.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static no.dfo.fp.functionalprogramming.model.Category.CLEANING;
import static no.dfo.fp.functionalprogramming.model.Category.FOOD;
import static no.dfo.fp.functionalprogramming.model.Category.OFFICE;
import static no.dfo.fp.functionalprogramming.model.Category.UTENSILS;

public class TestData {

    public static final Product PENCILS = new Product(OFFICE, "Pencils", new BigDecimal("5.79"));
    public static final Product APPLES = new Product(FOOD, "Apples", new BigDecimal("1.29"));
    public static final Product PLATES = new Product(UTENSILS, "Plates", new BigDecimal("12.95"));
    public static final Product SPAGHETTI = new Product(FOOD, "Spaghetti", new BigDecimal("2.79"));
    public static final Product COFFEE = new Product(FOOD, "Coffee", new BigDecimal("7.49"));
    public static final Product DETERGENT = new Product(CLEANING, "Detergent", new BigDecimal("3.79"));

    private static final List<Product> PRODUCTS = List.of(PENCILS, APPLES, PLATES, SPAGHETTI, COFFEE, DETERGENT);

    public static List<Product> getProducts() {
        return new ArrayList<>(PRODUCTS);
    }
}
