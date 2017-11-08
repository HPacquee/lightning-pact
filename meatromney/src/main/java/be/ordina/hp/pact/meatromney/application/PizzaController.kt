package be.ordina.hp.pact.meatromney.application

import be.ordina.hp.pact.meatromney.domain.MeatRomneyPizza
import org.springframework.core.ParameterizedTypeReference
import org.springframework.hateoas.Resources
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.util.stream.Collectors

@RestController
class PizzaController(private val restTemplate: RestTemplate) {

    val meatApprovedPizzas: List<MeatRomneyPizza>
        @GetMapping("/")
        get() {
            val responseEntity = restTemplate.exchange(
                    "http://localhost:8080/pizzas",
                    HttpMethod.GET, null,
                    object : ParameterizedTypeReference<Resources<MeatRomneyPizza>>() {

                    })
            return responseEntity.body.content.stream().filter { pizza -> pizza.isMeatRomneyApproved }.collect(Collectors.toList())
        }
}
