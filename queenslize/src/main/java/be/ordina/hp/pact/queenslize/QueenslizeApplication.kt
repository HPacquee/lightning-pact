package be.ordina.hp.pact.queenslize

import be.ordina.hp.pact.queenslize.domain.Pizza
import be.ordina.hp.pact.queenslize.domain.PizzaRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import java.math.BigDecimal
import java.util.*

@SpringBootApplication
open class QueenslizeApplication {

    @Bean
    open fun loadSomeData(pizzaRepository: PizzaRepository) = CommandLineRunner {
        pizzaRepository.save(Pizza(UUID.randomUUID(), "Margerita", BigDecimal.TEN, true, BigDecimal.TEN))
        pizzaRepository.save(Pizza(UUID.randomUUID(), "Meat lovers", BigDecimal.TEN, false, BigDecimal.TEN))
        pizzaRepository.save(Pizza(UUID.randomUUID(), "Hawaii", BigDecimal.TEN, false, BigDecimal.TEN))
        pizzaRepository.save(Pizza(UUID.randomUUID(), "Veggie", BigDecimal.TEN, true, BigDecimal.TEN))
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(QueenslizeApplication::class.java, *args)
}
