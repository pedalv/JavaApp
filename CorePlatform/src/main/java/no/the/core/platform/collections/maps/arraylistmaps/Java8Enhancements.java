package no.the.core.platform.collections.maps.arraylistmaps;


import no.the.core.platform.collections.model.Product;
import no.the.core.platform.collections.model.ProductFixtures;

import java.util.HashMap;
import java.util.Map;

public class Java8Enhancements
{
    public static void main(String[] args)
    {

        /*
            getOrDefault
            putIfAbsent
            compute
            computeIfAbsent
            computeIfPresent
            merge
            foreach

         */
        final Product defaultProduct = new Product(-1, "Whatever the customer wants", 100);

        final Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, ProductFixtures.door);
        idToProduct.put(2, ProductFixtures.floorPanel);
        idToProduct.put(3, ProductFixtures.window);


        System.out.println("getOrDefault");
        Product result = idToProduct.getOrDefault(10, defaultProduct);
        System.out.println(result);
        System.out.println(idToProduct.get(10));
        System.out.println();


        System.out.println("putIfAbsent");
        result = idToProduct.put(
                4,
                new Product(4,"Product Name",33)  );

        System.out.println(result); // return null
        System.out.println(idToProduct.get(4)); // put new product in idToProduct
        System.out.println();


        System.out.println("computeIfAbsent");
        result = idToProduct
            .computeIfAbsent(
                    10,
                    (id) -> new Product(id, "Custom Product", 10));
        System.out.println(result);
        System.out.println(idToProduct.get(10));
        System.out.println();


        System.out.println("replace");
        result = idToProduct.replace(1, new Product(1, "Big Door", 50));
        System.out.println(result); //print old value
        System.out.println(idToProduct.get(1)); //print new value
        System.out.println();
        //Note: if key does not exist it will be null, so it not update anything


        System.out.println("compute - update");
        result = idToProduct.compute(
                ProductFixtures.door.getId(),
                ( key, oldProduct ) ->
                        new Product(
                                oldProduct.getId(),
                                oldProduct.getName() + "Pedro",
                                oldProduct.getWeight() ));
        System.out.println(result); //print new update name
        System.out.println(idToProduct.get(1)); //print new update value
        System.out.println();


        System.out.println("compute - add");
        result = idToProduct.compute(
                22,
                ( name, weight) ->
                        new Product(
                                22,
                                "Pedro",
                                75 ));
        System.out.println(result); //print new update name
        System.out.println(idToProduct.get(22)); //print new update value
        System.out.println();


        System.out.println("computeIfPresent");
        result = idToProduct.computeIfPresent(
                ProductFixtures.floorPanel.getId(),
                ( key, oldProduct ) ->
                        new Product(
                                oldProduct.getId(),
                                oldProduct.getName() + "Pedro",
                                oldProduct.getWeight() ));
        System.out.println(result); //print new update name
        System.out.println(idToProduct.get(1)); //print new update neme
        System.out.println();


        System.out.println("replaceAll");
        System.out.println(idToProduct);
        idToProduct.replaceAll(
                ( key, oldProduct ) ->
                    new Product(
                            oldProduct.getId(),
                            oldProduct.getName(),
                            oldProduct.getWeight() + 10));
        System.out.println(idToProduct);
        System.out.println();


        System.out.println("forEach");
        idToProduct.forEach(
                (key, value) ->
                        System.out.println(key + " -> " + value));

        System.out.println("merge - update");
        System.out.println(idToProduct.get(1)); //print
        System.out.println();


        idToProduct.merge(
                1,
                new Product(
                        1,
                        "Big Door",
                        100),
                ( key, oldProduct ) ->
                        new Product(
                                oldProduct.getId(),
                                "Big Door",
                                oldProduct.getWeight() + 30));
        System.out.println(idToProduct.get(1)); //print new update name
        System.out.println();

        System.out.println("merge - add");
        System.out.println(idToProduct.get(12)); //return null
        idToProduct.merge(
                12,
                new Product(
                        12,
                        "merge add",
                        112),
                ( key, oldProduct ) ->
                        new Product(
                                oldProduct.getId(),
                                "Big Door",
                                oldProduct.getWeight() + 30));
        System.out.println(idToProduct.get(12)); //print new product
        System.out.println();

    }
}
