package no.insurance.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by p on 29/10/2016.
 */
@Entity
@JsonIgnoreProperties
public class Letter {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotNull
    Long userid;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Min(1)
    @Max(7)
    Integer type;

    @NotNull
    @Size(max=2000)
    String product;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Min(1)
    @Max(6)
    Integer state;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    Double price;

    public Letter() {

    }

    public Letter(Long userid, Integer type, String product, Integer state, Double price) {
        this.userid = userid;
        this.type = type;
        this.product = product;
        this.state = state;
        this.price = price;
    }

    public Letter(Long id, Long userid, Integer type, String product, Integer state, Double price) {
        this.id = id;
        this.userid = userid;
        this.type = type;
        this.product = product;
        this.state = state;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Service [id=" + id + ",  userid=" + userid + ", Insurance type=" + type + ", product=" + product + ", state=" + state + ", price=" + price + "]";
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Long getUserid() {

        return userid;
    }

    public void setUserid(Long userId) {

        this.userid = userId;
    }

    public Integer getType() {

        return type;
    }

    public void setType(Integer type) {

        this.type = type;
    }

    public String getProduct() {

        return product;
    }

    public void setProduct(String product) {

        this.product = product;
    }

    public Integer getState() {

        return state;
    }

    public void setState(Integer state) {

        this.state = state;
    }

    public Double getPrice() {

        return price;
    }

    public void setPrice(Double price) {

        this.price = price;
    }
}
