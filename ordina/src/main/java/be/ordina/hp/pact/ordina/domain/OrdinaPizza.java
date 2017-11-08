package be.ordina.hp.pact.ordina.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrdinaPizza {

    private String name;
    private BigDecimal price;
    private BigDecimal diameter;

    OrdinaPizza() {
        //empty JPA/JSON constructor
    }

    public OrdinaPizza(String name, BigDecimal price, BigDecimal diameter) {
        this.name = name;
        this.price = price;
        this.diameter = diameter;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getDiameter() {
        return diameter;
    }

    public String getName() {
        return name;
    }
}
