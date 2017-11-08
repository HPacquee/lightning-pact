package be.ordina.hp.pact.annhannah.pact;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import be.ordina.hp.pact.annhannah.application.PizzaController;
import be.ordina.hp.pact.annhannah.domain.MeatRomneyPizza;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueenSlizePactTest {

    @Rule
    public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("queenslize-rest-api", "localhost", 8080, this);

    @Autowired
    private PizzaController pizzaController;

    @Test
    @PactVerification
    public void getMeatRomneysApprovedPizzasRepresentation() {
        final List<MeatRomneyPizza> allPizzas = pizzaController.getMeatApprovedPizzas();
        System.out.println(allPizzas);
        Assert.assertThat(allPizzas, Matchers.hasSize(1));
    }

    @Pact(consumer="meat-romney")
    public RequestResponsePact createPact(PactDslWithProvider builder) {

        PactDslJsonBody expectedOrdinaPizzaCollection = new PactDslJsonBody()
                    .object("_embedded")
                        .eachLike("pizzas")
                            .stringType("name", "Meat Lovers")
                            .booleanType("vegetarian", false)
                        .closeArray()
                    .closeObject()
                .asBody();

        return builder
                .given("pizzas are present")
                .uponReceiving("A request for the full menu")
                .path("/pizzas")
                .method("GET")
                .willRespondWith()
                .matchHeader("Content-Type", "application\\/hal\\+json;charset=UTF-8")
                .status(200)
                .body(expectedOrdinaPizzaCollection)
                .toPact();


    }

}
