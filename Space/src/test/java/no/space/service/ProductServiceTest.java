package no.space.service;

import no.space.model.Product;
import no.space.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    private Product expectedProduct;
    private List<Product> expectedProducts;
    private Long userId1;

    private ProductService _productServiceMock = new ProductService();

    private ProductRepository _productRepositoryMock = new ProductRepository();

    @Before
    public void setUp() throws Exception {
        expectedProducts = new ArrayList<>();
        userId1 = 1L;
        expectedProduct = new Product( 1, "M");
        expectedProducts.add(expectedProduct);
    }

    @Test
    public void testList() throws Exception {

        List<Product> actualProducts = _productServiceMock.list();

        assertNotNull(actualProducts);
        assertEquals(actualProducts.toArray().length,6);
    }

}