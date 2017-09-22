package no.the.core.platform.collections.operations.algorithms;

import no.the.core.platform.collections.model.Product;
import no.the.core.platform.collections.model.ProductFixtures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rotate
{
    public static void main(String[] args)
    {
        List<Product> products = new ArrayList<>();
        products.add(ProductFixtures.door);
        products.add(ProductFixtures.floorPanel);
        products.add(ProductFixtures.window);

        System.out.println(products);
        System.out.println();

        Collections.rotate(products, 1);
        System.out.println(products);
        System.out.println();

        Collections.rotate(products, 1);
        System.out.println(products);
        System.out.println();

        Collections.rotate(products, 1);
        System.out.println(products);
    }
}
