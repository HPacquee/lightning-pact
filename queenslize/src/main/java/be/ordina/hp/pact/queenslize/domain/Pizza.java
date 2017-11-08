package be.ordina.hp.pact.queenslize.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
public class Pizza {

    @Id
    private UUID id;

    private String name;

    private BigDecimal price;

    private boolean vegetarian;

    private BigDecimal diameter;

    @ElementCollection(targetClass=Ingredient.class)
    private List<Ingredient> ingredients;

    Pizza() {
        //empty JPA/JSON constructor
    }

    public Pizza(String name, BigDecimal price, BigDecimal diameter, Ingredient... ingredients) {

        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.diameter = diameter;
        this.ingredients = Collections.unmodifiableList(Arrays.asList(ingredients));
        this.vegetarian = !this.ingredients.contains(Ingredient.MEAT);
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public enum Ingredient {
        CHEESE,
        TOMATO_SAUCE,
        MEAT,
        BELL_PEPPER,
        PINEAPPLE
    }
}
