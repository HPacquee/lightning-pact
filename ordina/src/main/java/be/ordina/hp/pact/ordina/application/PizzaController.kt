package be.ordina.hp.pact.ordina.application

import be.ordina.hp.pact.ordina.domain.OrdinaPizza
import org.springframework.core.ParameterizedTypeReference
import org.springframework.hateoas.Resources
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

import java.util.ArrayList
import java.util.Arrays
import java.util.Collections

@RestController
class PizzaController(private val restTemplate: RestTemplate) {

    val allPizzas: List<OrdinaPizza>
        @GetMapping("/")
        get() {
            val responseEntity = restTemplate.exchange(
                    "http://localhost:8080/pizzas",
                    HttpMethod.GET, null,
                    object : ParameterizedTypeReference<Resources<OrdinaPizza>>() {

                    })
            return ArrayList(responseEntity.body.content)
        }
}
