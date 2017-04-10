package no.insurance.service;

import no.insurance.domain.Product;
import no.insurance.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by p on 29/10/2016.
 */
@RestController
@RequestMapping("api/v1/")
public class ProductService {
    @Autowired
    private ProductRepository _productRepository;


    @RequestMapping(value = "product", method = RequestMethod.GET)
    public List<Product> list() {

        return _productRepository.findAll();
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public Product create(@RequestBody Product product) {

        return _productRepository.save(product);
    }

    @RequestMapping(value = "product/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable Long id) {

        return _productRepository.findOne(id);
    }

    @RequestMapping(value = "product/{id}", method = RequestMethod.PUT)
    public Product update(@PathVariable Long id, @RequestBody Product product) {

        Product existingProcuct = _productRepository.findOne(id);
        BeanUtils.copyProperties(product, existingProcuct);
        return _productRepository.save(existingProcuct);

    }

    @RequestMapping(value = "product/{id}", method = RequestMethod.DELETE)
    public Product delete(@PathVariable Long id) {

        Product existingProcuct = _productRepository.findOne(id);
        _productRepository.delete(existingProcuct);
        return existingProcuct;
    }
}
