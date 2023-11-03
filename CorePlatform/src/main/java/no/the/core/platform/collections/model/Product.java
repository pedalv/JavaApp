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

    public static final Comparator<Product> BY_NAME =
            comparing(Product::getName);

    private int id;
    private final String name;
    private final int weight;

    public Product(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Product(int id, String name, int weight)
    {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
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
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!(o instanceof Product)) return false;

        final Product product = (Product) o;

        if (weight != product.weight) return false;
        return name.equals(product.name);
        //return Objects.equals(weight, product.weight) && Objects.equals(name, product.name);
        //Objects.equals(name, product.name) //It deals with null checks
    }


    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + weight;
        return result;
        //Objects.hash(name, weight); // Java 7
        //Arrays.hashCode()
        //(int)(l^(l>>> 32)) for longs
        //Float.floatToIntBits(f);
    }


}
