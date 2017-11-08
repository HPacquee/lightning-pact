package be.ordina.hp.pact.meatromney.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.beans.Transient;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MeatRomneyPizza {

    private String name;
    @JsonProperty(access = WRITE_ONLY)
    private boolean vegetarian;

    MeatRomneyPizza() {
        //empty JPA/JSON constructor
    }

    public MeatRomneyPizza(String name, boolean vegetarian) {
        this.name = name;
        this.vegetarian = vegetarian;
    }

    public String getName() {
        return name;
    }

    public boolean isMeatRomneyApproved() {
        return !vegetarian;
    }
}
