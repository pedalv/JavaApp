package no.space.repository;

import no.space.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private static List<Product> products = populate();

    private static List<Product> populate() {

        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"CAPPUCHINO"));
        products.add(new Product(2,"AMERICANO"));
        products.add(new Product(3,"ESPRESSO"));
        products.add(new Product(4,"MACCHIATO"));
        products.add(new Product(5,"MOCHA"));
        products.add(new Product(6,"LATTE"));

        return products;
    }


    public List<Product> findAll() {

        return products;

    }


    public Product getOne(int id) {

        return products.get(id);

    }


}
