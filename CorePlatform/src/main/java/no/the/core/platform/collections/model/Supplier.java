package no.the.core.platform.collections.model;

import java.util.ArrayList;
import java.util.List;

public class Supplier {

    private final String name;
    private final List<Product> products = new ArrayList<>();

    public Supplier(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public List<Product> getProducts()
    {
        return products;
    }

    public List<Product> products()
    {
        return products;
    }

    @Override
    public String toString()
    {
        return "Supplier{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }

}
