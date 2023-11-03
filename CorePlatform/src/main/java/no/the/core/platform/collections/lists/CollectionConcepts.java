package no.the.core.platform.collections.lists;

import no.the.core.platform.collections.model.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionConcepts {

    public static void main(String[] args)
    {
        Product door = new Product("Wooden Door", 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window = new Product("Glass Window", 10);

        Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);

        // 0. Iterable
        // 1. Collection with foreach
        // 2. Can't print out and remove - CME
        // 3. refactor to iterator

        Iterator<Product> iterator = products.iterator();
        /*
            Note:
            - Iterator: Good for remove, add, etc during the loop
            - for loop: use always for loop other ways
        */
        while (iterator.hasNext())
        {
            final Product product = iterator.next();
            if (product.getWeight() > 20)
            {
                System.out.println(product);
            }
            else
            {
                iterator.remove();
            }
        }

        System.out.println(products);

        // 4. other methods

        System.out.println(products.size());
        System.out.println(products.isEmpty());

        System.out.println(products.contains(floorPanel));

        products.remove(floorPanel);

        System.out.println(products.contains(floorPanel));

        // 5. removeAll
        List<Product> otherProducts = new ArrayList<>();
        otherProducts.add(door);
        otherProducts.add(window);

        products.removeAll(otherProducts);
        System.out.println(products);
    }

}
