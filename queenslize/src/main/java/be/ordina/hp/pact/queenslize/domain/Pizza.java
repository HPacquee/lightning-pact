package be.ordina.hp.pact.queenslize.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Pizza {

    @Id
    private UUID id;

    private String name;

    private BigDecimal price;

    private boolean vegetarian;

    private BigDecimal diameter;

    Pizza() {
        //empty JPA/JSON constructor
    }

    public Pizza(String name, BigDecimal price, boolean vegetarian, BigDecimal diameter) {

        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.vegetarian = vegetarian;
        this.diameter = diameter;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public BigDecimal getDiameter() {
        return diameter;
    }
}
