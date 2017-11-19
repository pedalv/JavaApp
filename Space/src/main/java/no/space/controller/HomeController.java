package no.space.controller;

import no.space.model.Product;
import no.space.repository.ProductRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by p on 19/11/2017.
 */
@RestController
public class HomeController {

    private ProductRepository _productRepository = new ProductRepository();

    @RequestMapping("/")
    public String home() {

        return "Case coffee machine project for Spring Boot";

    }

    @RequestMapping("/coffeemachine")
    public String coffeemachine() {

        //1	 GET	Awake machine, briefing	 /api/v1/coffeemachine/briefing

        //2	 GET	Select product	         /api/v1/coffeemachine/product

        //3	 GET	Product options	         /api/v1/coffeemachine/option

        //4	 POST   Pay	                     /api/v1/coffeemachine/payment

        //5	 GET	Product Selected	     /api/v1/coffeemachine/product

        //6	 GET	Cancel order	         /api/v1/coffeemachine/product-options


        Product p = _productRepository.getOne(1);

        return "index.html: " + p.getName();

    }

}

