package be.ordina.hp.pact.queenslize;

import be.ordina.hp.pact.queenslize.domain.Pizza;
import be.ordina.hp.pact.queenslize.domain.PizzaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

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
		pizzaRepository.save(new Pizza("Margerita", BigDecimal.TEN, true, BigDecimal.TEN));
		pizzaRepository.save(new Pizza("Meat lovers", BigDecimal.TEN, false,BigDecimal.TEN));
		pizzaRepository.save(new Pizza("Hawaii", BigDecimal.TEN, false, BigDecimal.TEN));
		pizzaRepository.save(new Pizza("Veggie", BigDecimal.TEN, true, BigDecimal.TEN));
		LOGGER.info("DONE LOADING DATA");


	}

}
