package no.insurance.helper;

import no.insurance.domain.Letter;
import no.insurance.domain.Product;
import no.insurance.domain.User;

/**
 * Created by p on 29/10/2016.
 */
public class CreateLetter {

    public CreateLetter() {
    }

    public User UserForm() {

        String firstname = "Pedro";
        String Lastname = "Alves";
        String email = "pa@pa.no";

        return new User(firstname, Lastname, email);
    }

    public Product ProductForm() {

        int type = Insurance.CAR.getValue();
        int state = State.PENDING.getValue();
        String description = "Information about my car";

        return new Product(type, state, description);
    }

    public Letter SendProduct(IdUserProduct idUserProduct) {

        return new Letter(idUserProduct.getUserid(), Insurance.CAR.getValue(), "product", State.SEND.getValue(), 4999.66);
    }

    public Letter UserPay(Letter letter) {

        letter.setState(State.PAY.getValue());

        return letter;
    }




}
