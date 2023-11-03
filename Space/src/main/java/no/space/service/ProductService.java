package no.space.service;

import no.space.model.Product;
import no.space.repository.ProductRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ProductService {

    private ProductRepository _productRepository = new ProductRepository();

    @RequestMapping(value = "product", method = RequestMethod.GET)
    public List<Product> list() {

        return _productRepository.findAll();
    }


}







