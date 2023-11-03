package no.insurance.Service;

import no.insurance.domain.Product;
import no.insurance.repository.ProductRepository;
import no.insurance.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by p on 29/10/2016.
 */
public class ProductServiceTest {

    private Product expectedProduct;
    private List<Product> expectedProducts;
    private Long userId1;

    @InjectMocks
    private ProductService _productServiceMock;

    @Mock
    private ProductRepository _productRepositoryMock;

    @Before
    public void setUp() throws Exception {
        expectedProducts = new ArrayList<Product>();
        userId1 = 1L;
        expectedProduct = new Product(1L, 1, 6, "Information about my car and me");
        expectedProducts.add(expectedProduct);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testList() throws Exception {
        //MOCHITO
        when(_productRepositoryMock.findAll()).thenReturn(expectedProducts);

        List<Product> actualProducts = _productServiceMock.list();

        assertNotNull(actualProducts);
        assertEquals(actualProducts.toArray().length,1);

        //verify if method was call
        verify(_productRepositoryMock).findAll();

        assertEquals( expectedProducts.get(0).getId().longValue(), actualProducts.get(0).getId().longValue() );

        //Hamcrest
        assertThat(expectedProducts.get(0).getId(), is(actualProducts.get(0).getId()));
    }

    @Test
    public void testCreate() throws Exception {
        Product productCreate = new Product(1L, 1, 6, "Information about my car and me");

        //MOCHITO
        when(_productRepositoryMock.save(productCreate)).thenReturn(productCreate);

        Product created = _productServiceMock.create(productCreate);
        assertNotNull(created);

        //verify if method was call
        verify(_productRepositoryMock).save(productCreate);

        assertEquals(created.toString(),productCreate.toString());
    }

    @Test
    public void testGet() throws Exception {
        Product usergetOne = new Product(1L, 1, 6, "Information about my car and me");

        //MOCHITO
        when(_productRepositoryMock.findOne(1L)).thenReturn(usergetOne);

        Product getActual = _productServiceMock.get(1L);
        assertNotNull(getActual);

        //verify if method was call
        verify(_productRepositoryMock).findOne(1L);
    }

    @Test
    public void testUpdate() throws Exception {

        Product productfind = new Product(1L, 1, 6, "Information about my car and me");
        Product productChange = new Product(1L, 1, 6, "Information about my boat and me");

        //MOCHITO
        when(_productRepositoryMock.findOne(1L)).thenReturn(productfind);
        when(_productRepositoryMock.save(productChange)).thenReturn(productChange);

        _productServiceMock.update(1L, productChange);

        //verify if method was call
        verify(_productRepositoryMock).findOne(1L);
        verify(_productRepositoryMock).save(productfind);

        assertNotNull(productfind);
        assertEquals(productfind.getDescription(),productChange.getDescription());

    }

    @Test
    public void testDelete() throws Exception {

        Product productdelete = new Product(1L, 1, 6, "Information about my car and me");

        //MOCHITO
        when(_productRepositoryMock.findOne(1L)).thenReturn(productdelete);

        Product userUpdated = _productServiceMock.delete(1L);

        //verify if method was call
        verify(_productRepositoryMock).findOne(1L);

    }
}
