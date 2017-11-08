package be.ordina.hp.pact.meatromney

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class MeatromneyApplication {


}

fun main(args: Array<String>) {
    SpringApplication.run(MeatromneyApplication::class.java, *args)
}
