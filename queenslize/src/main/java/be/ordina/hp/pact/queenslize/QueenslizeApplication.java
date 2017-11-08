package be.ordina.hp.pact.queenslize;

import be.ordina.hp.pact.queenslize.domain.Pizza;
import be.ordina.hp.pact.queenslize.domain.PizzaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

import static be.ordina.hp.pact.queenslize.domain.Pizza.Ingredient.*;

@SpringBootApplication
public class QueenslizeApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueenslizeApplication.class, args);
	}
}

@Component
class DataLoader {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataLoader.class);
	private final PizzaRepository pizzaRepository;

	DataLoader(PizzaRepository pizzaRepository) {
		this.pizzaRepository = pizzaRepository;
	}

	@PostConstruct
	public void loadSomeData() {
		LOGGER.info("STARTED LOADING DATA");
		pizzaRepository.save(new Pizza("Margerita", BigDecimal.TEN, BigDecimal.TEN, TOMATO_SAUCE, CHEESE));
		pizzaRepository.save(new Pizza("Meat lovers", BigDecimal.TEN,BigDecimal.TEN, TOMATO_SAUCE, CHEESE, MEAT, MEAT, MEAT));
		pizzaRepository.save(new Pizza("Hawaii", BigDecimal.TEN, BigDecimal.TEN, TOMATO_SAUCE, CHEESE, MEAT, PINEAPPLE));
		pizzaRepository.save(new Pizza("Veggie", BigDecimal.TEN, BigDecimal.TEN, TOMATO_SAUCE, CHEESE, BELL_PEPPER));
		LOGGER.info("DONE LOADING DATA");


	}

}
