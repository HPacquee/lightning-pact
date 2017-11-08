package be.ordina.hp.pact.ordina.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

import java.math.BigDecimal

@JsonIgnoreProperties(ignoreUnknown = true)
data class OrdinaPizza(val name: String = "", val price: BigDecimal = BigDecimal.ZERO, val diameter: BigDecimal = BigDecimal.ZERO)
