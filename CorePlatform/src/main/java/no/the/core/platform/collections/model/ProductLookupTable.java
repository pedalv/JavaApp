package no.the.core.platform.collections.model;

public interface ProductLookupTable
{
    Product lookupById(int id);

    void addProduct(Product productToAdd);

    void clear();
}
