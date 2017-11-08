package be.ordina.hp.pact.ordina.application;

import be.ordina.hp.pact.ordina.domain.OrdinaPizza;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class PizzaController {

    private final RestTemplate restTemplate;


    public PizzaController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/")
    public List<OrdinaPizza> getAllPizzas() {
        final ResponseEntity<Resources<OrdinaPizza>> responseEntity = restTemplate.exchange(
                "http://localhost:8080/pizzas",
                HttpMethod.GET, null,
                new ParameterizedTypeReference<Resources<OrdinaPizza>>() {
                });
        return new ArrayList<>(responseEntity.getBody().getContent());
    }
}
