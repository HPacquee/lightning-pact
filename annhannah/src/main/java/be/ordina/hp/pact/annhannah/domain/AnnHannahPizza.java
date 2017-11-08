package be.ordina.hp.pact.annhannah.domain;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;
import static org.springframework.util.CollectionUtils.isEmpty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnnHannahPizza {

    private static final String PINEAPPLE = "PINEAPPLE";
    private String name;
    @JsonProperty(value = "ingredients", access = WRITE_ONLY)
    private List<String> ingredients = new ArrayList<>();

    AnnHannahPizza() {
        //empty JPA/JSON constructor
    }

    public AnnHannahPizza(String name, List<String> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public boolean hasMagnificentlyDeliciousPineapple() {
        return !isEmpty(ingredients) && ingredients.contains(PINEAPPLE);
    }
}
