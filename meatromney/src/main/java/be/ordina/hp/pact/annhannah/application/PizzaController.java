package be.ordina.hp.pact.annhannah.application;

import be.ordina.hp.pact.annhannah.domain.MeatRomneyPizza;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PizzaController {

    private final RestTemplate restTemplate;


    public PizzaController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public List<MeatRomneyPizza> getMeatApprovedPizzas() {
        final ResponseEntity<Resources<MeatRomneyPizza>> responseEntity = restTemplate.exchange(
                "http://localhost:8080/pizzas",
                HttpMethod.GET, null,
                new ParameterizedTypeReference<Resources<MeatRomneyPizza>>() {
                });
        return responseEntity.getBody().getContent().stream().filter(pizza -> pizza.isMeatRomneyApproved()).collect(Collectors.toList());
    }
}
