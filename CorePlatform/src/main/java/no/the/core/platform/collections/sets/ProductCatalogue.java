package no.the.core.platform.collections.sets;

import no.the.core.platform.collections.model.Product;
import no.the.core.platform.collections.model.Supplier;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ProductCatalogue implements Iterable<Product>
{
    //private Set<Product> products = new HashSet<>();
    // - Need rewrite equals and hasCode
    private final Set<Product> products = new TreeSet<>(Product.BY_NAME);
    // - Need to pass a Comparator parameter

    public void isSuppliedBy(Supplier supplier)
    {
        products.addAll(supplier.getProducts());
    }

    public Iterator<Product> iterator()
    {
        return products.iterator();
    }
}

