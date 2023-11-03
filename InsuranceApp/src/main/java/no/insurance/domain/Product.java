package no.insurance.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by p on 21/10/2016.
 */
@Entity
@JsonIgnoreProperties
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Min(1)
    @Max(7)
    Integer type;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Min(1)
    @Max(6)
    Integer state;

    @NotNull
    @Size(max=2000)
    String description;

    public Product() {

    }

    public Product(Integer type, Integer state, String description) {
        this.type = type;
        this.state = state;
        this.description = description;
    }

    public Product(Long id, Integer type, Integer state, String description) {
        this.id = id;
        this.type = type;
        this.state = state;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", Insurance type=" + type + ", Satete=" + state + ", description=" + description + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
}
