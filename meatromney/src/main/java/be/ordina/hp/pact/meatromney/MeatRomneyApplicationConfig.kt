package be.ordina.hp.pact.meatromney

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
open class MeatRomneyApplicationConfig {

    @Bean
    open fun restTemplate(): RestTemplate {
        val restTemplate = RestTemplate()
        return restTemplate
    }
}
