package no.the.core.platform.collections.maps.arraylistmaps;

import no.the.core.platform.collections.model.Product;
import no.the.core.platform.collections.model.ProductFixtures;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ViewsOverMaps
{
    public static void main(String[] args)
    {
        final Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, ProductFixtures.door);
        idToProduct.put(2, ProductFixtures.floorPanel);
        idToProduct.put(3, ProductFixtures.window);

        System.out.println(idToProduct);
        System.out.println();

        final Set<Integer> ids = idToProduct.keySet();
        System.out.println("ids: " + ids);
        System.out.println();

        ids.remove(1);
        System.out.println(ids);
        System.out.println(idToProduct);
        System.out.println();

        // ids.add(1);
        //Exception in thread "main" java.lang.UnsupportedOperationException

        final Collection<Product> products = idToProduct.values();
        System.out.println(products);
        System.out.println();

        products.remove(ProductFixtures.floorPanel);
        System.out.println(products);
        System.out.println(idToProduct);
        System.out.println();

         //products.add(ProductFixtures.floorPanel);
         //Exception in thread "main" java.lang.UnsupportedOperationException

        final Set<Map.Entry<Integer, Product>> entries = idToProduct.entrySet();
        for(Map.Entry<Integer, Product> entry : entries)
        {
            System.out.println("-");
            System.out.println(entry);
            //entry.setValue(ProductFixtures.door); //change key and value in idToProduct
            System.out.println("--");
        }

        idToProduct.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
