package be.ordina.hp.pact.queenslize.pact;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import be.ordina.hp.pact.queenslize.QueenslizeApplication;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

@RunWith(PactRunner.class)
@Provider("queenslize-rest-api")
@PactFolder("pacts")
public class QueenSlizeProviderPactVerificationTest {

    private static ConfigurableApplicationContext run;

    @TestTarget
    public final Target target = new HttpTarget(8080);

    @State("pizzas are present")
    public void pizzasArePresent() {

    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        run = new SpringApplicationBuilder().profiles("pact").build().run(QueenslizeApplication.class);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        run.stop();
    }
}
