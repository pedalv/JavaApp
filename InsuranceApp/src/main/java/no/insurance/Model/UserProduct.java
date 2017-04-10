package no.insurance.Model;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by p on 29/10/2016.
 */
public class UserProduct {

    //USER

    @NotNull
    @Size(max=255)
    String firstname;

    @NotNull
    @Size(max=255)
    String lastname;

    @NotNull
    @Email
    @Size(max=255)
    String email;

    @NotNull
    @Size(min = 6, max = 30)
    String password;

    //Product

    @NotNull
    @Size(max = 2000)
    String product;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Min(1)
    @Max(7)
    Integer type;

    // Letter

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    Long productId;

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Min(1)
    @Max(5)
    Integer state;

    @Size(max = 2000)
    String description;

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    Double price;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}