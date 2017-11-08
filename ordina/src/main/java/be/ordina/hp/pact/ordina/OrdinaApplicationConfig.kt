package be.ordina.hp.pact.ordina

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
open class OrdinaApplicationConfig {

    @Bean
    open fun restTemplate(): RestTemplate {
        val restTemplate = RestTemplate()
        return restTemplate
    }
}
