package be.ordina.hp.pact.ordina

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class OrdinaApplication {
}

fun main(args: Array<String>) {
    SpringApplication.run(OrdinaApplication::class.java, *args)
}
