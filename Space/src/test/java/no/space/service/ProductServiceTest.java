package no.space.service;

import no.space.model.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProductServiceTest {

    private Product expectedProduct;
    private List<Product> expectedProducts;
    private Long userId1;

    private ProductService _productServiceMock = new ProductService();

    @Before
    public void setUp() throws Exception {
        expectedProducts = new ArrayList<>();
        userId1 = 1L;
        expectedProducts.add(new Product(1,"CAPPUCHINO"));
        expectedProducts.add(new Product(2,"AMERICANO"));
        expectedProducts.add(new Product(3,"ESPRESSO"));
        expectedProducts.add(new Product(4,"MACCHIATO"));
        expectedProducts.add(new Product(5,"MOCHA"));
        expectedProducts.add(new Product(6,"LATTE"));
    }

    @Test
    public void testList() throws Exception {

        List<Product> actualProducts = _productServiceMock.list();

        assertNotNull(actualProducts);
        assertEquals(actualProducts.toArray().length,expectedProducts.size());
    }

}