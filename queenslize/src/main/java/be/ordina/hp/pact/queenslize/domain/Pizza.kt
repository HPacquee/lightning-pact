package be.ordina.hp.pact.queenslize.domain

import java.math.BigDecimal
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Pizza(@Id val id: UUID = UUID.randomUUID(),
                 val name: String = "",
                 val price: BigDecimal = BigDecimal.ZERO,
                 val isVegetarian: Boolean = false,
                 val diameter: BigDecimal = BigDecimal.ZERO)
