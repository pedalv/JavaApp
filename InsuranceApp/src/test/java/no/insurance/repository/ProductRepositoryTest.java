package no.insurance.repository;

import no.insurance.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by p on 29/10/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository _productRepository;

    @Test
    public void testFindAll() {
        List<Product> letters = _productRepository.findAll();
        assertThat(letters.size(), is(greaterThanOrEqualTo(0)));
    }

    @Test
    public void test_located_ProctuctService(){
        /*
        //_productRepository.findAll();
        _productRepository.saveAndFlush(letter);
        _productRepository.findOne(id);
        _productRepository.saveAndFlush(existingLetter);
        _productRepository.delete(existingLetter);
        */
    }

}
