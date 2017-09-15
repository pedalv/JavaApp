package no.the.core.platform.collections.model;

import java.util.Comparator;

import static java.util.Comparator.comparing;

public class Product {

    /* Java 7
    public static final Comparator<Product> BY_WEIGHT
            = new Comparator<Product>()
    {
        public int compare(final Product p1, final Product p2)
        {
            return Integer.compare(p1.getWeight(), p2.getWeight());
        }
    };
    */

    /* Java 8 */
    public static final Comparator<Product> BY_WEIGHT
            = comparing(Product::getWeight);

    private final String name;
    private final int weight;

    public Product(String name, int weight)
    {
        this.name = name;
        this.weight = weight;
    }

    public String getName()
    {
        return name;
    }

    public int getWeight()
    {
        return weight;
    }

    @Override
    public String toString()
    {
        return "Product{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

}
