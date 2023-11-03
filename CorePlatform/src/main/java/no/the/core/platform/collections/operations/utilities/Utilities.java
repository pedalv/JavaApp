package no.the.core.platform.collections.operations.utilities;

import no.the.core.platform.collections.model.Product;
import no.the.core.platform.collections.model.ProductFixtures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utilities
{
    public static void main(String[] args)
    {
        Product door = ProductFixtures.door;
        Product floorPanel = ProductFixtures.floorPanel;
        Product window = ProductFixtures.window;

        System.out.println("addAll");
        List<Product> products = new ArrayList<>();
        Collections.addAll(products, door, floorPanel, window);
        System.out.println(products);

        System.out.println("min BY_NAME");
        final Product product_min_name =  Collections.min(products, Product.BY_NAME);
        System.out.println(product_min_name);

        System.out.println("max BY_NAME");
        final Product product_max_name = Collections.max(products, Product.BY_NAME);
        System.out.println(product_max_name);

        System.out.println("max BY_WEIGHT");
        final Product product_max_weight = Collections.max(products, Product.BY_WEIGHT);
        System.out.println(product_max_weight);

        System.out.println("min BY_WEIGHT");
        final Product product_min_weight = Collections.min(products, Product.BY_WEIGHT);
        System.out.println(product_min_weight);
    }
}
