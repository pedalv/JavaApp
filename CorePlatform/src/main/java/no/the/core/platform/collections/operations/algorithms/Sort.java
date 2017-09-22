package no.the.core.platform.collections.operations.algorithms;

import no.the.core.platform.collections.model.Product;
import no.the.core.platform.collections.model.ProductFixtures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort
{
    public static void main(String[] args)
    {
        List<Product> products = new ArrayList<>();
        products.add(ProductFixtures.door);
        products.add(ProductFixtures.floorPanel);
        products.add(ProductFixtures.window);

        System.out.println(products);

        //Collections.sort(products,Product.BY_NAME); //Java 7
        products.sort(Product.BY_NAME); // Java 8
        System.out.println(products);

        //Collections.sort(products,Product.BY_WEIGHT); // Java 7
        products.sort(Product.BY_WEIGHT); // Java 8
        System.out.println(products);
    }
}
