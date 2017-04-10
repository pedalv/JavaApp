package no.insurance.controller;

import no.insurance.domain.Letter;
import no.insurance.domain.Product;
import no.insurance.domain.User;
import no.insurance.helper.CreateLetter;
import no.insurance.helper.IdUserProduct;
import no.insurance.helper.State;
import no.insurance.repository.LetterRepository;
import no.insurance.repository.ProductRepository;
import no.insurance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * Created by p on 20/10/2016.
 */
@RestController
public class HomeController {

    @Autowired
    private UserRepository _userRepository;

    @Autowired
    private ProductRepository _productRepository;

    @Autowired
    private LetterRepository _letterRepository;


    @RequestMapping("/")
    public String home() {

        return "Case insurance contract project for Spring Boot";

    }

    @RequestMapping("/insurance")
    public String Insurance() {

        CreateLetter createLetter = new CreateLetter();

        //Get user and product from a form
        User userform = createLetter.UserForm();
        Product productform = createLetter.ProductForm();

        try {
            // create user and product
            Future<User> user = createUser(userform);
            Future<Product> product = createProduct(productform);

            // Wait until they are all done
            while (!(user.isDone() && product.isDone())) {
                Thread.sleep(10); //10-millisecond pause between each check
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Create clients letter to send
        IdUserProduct idUserProduct = new IdUserProduct();
        idUserProduct.setUserid(userform.getId());
        idUserProduct.setProductId(productform.getId());
        Letter sended = createLetter.SendProduct(idUserProduct);
        Letter pay = _letterRepository.save(sended);

        // client received letter and paid
        Letter insuranceActive = createLetter.UserPay(pay);

        // Update product that it is paid
        productform.setState(State.PAY.getValue());
        productform = _productRepository.save(productform);
        // Activate insurance
        insuranceActive.setState(State.ACTIVE.getValue());
        Letter insuranceActived = _letterRepository.save(insuranceActive);
        // client receive product id and state of insurance
       return "Product_id: " + productform.getId() + ", State: " + insuranceActived.getState();
    }


    @Async
    private Future<User> createUser(User user) throws InterruptedException {
        User results = _userRepository.save(user);
        // Artificial delay of 2s for demonstration purposes
        Thread.sleep(2000L);
        return new AsyncResult<User>(results);
    }

    @Async
    private Future<Product> createProduct(Product product) throws InterruptedException {
        Product results = _productRepository.save(product);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return new AsyncResult<Product>(results);
    }





/*
    @RequestMapping("/test")
    public String Insurance() {

        CreateUserProduct createUserProduct = new CreateUserProduct();

        //TODO: show form about user + product + submit
        UserProduct up = new UserProduct();

        //TODO: Create user, create product
        up.setFirstname("Pedro");
        up.setLastname("Alves");
        up.setEmail("pa@pa.no");
        up.setType(Insurance.CAR.getValue());
        up.setDescription("Information about my car");

        User user = new User(up.getFirstname(), up.getLastname(), up.getEmail());
        Product product = new Product(up.getType(), up.getDescription() );

        IdUserProduct idUserProduct = createUserProduct.createUserProduct(user, product);

        //TODO: send letter for user confirm

        up.setState(State.SEND.getValue());
        up.setPrice(5000.0);


        //TODO: User confirm
        up.setState(State.PAY.getValue());


        //Create: letter
        _letterRepository.save();


        //TODO: Insurance is active
        up.setState(State.ACTIVE.getValue());
        up.setProductId(idUserProduct.getProductId());
        _letterRepository.save();

        return "TODOS";
    }
*/
}