package be.ordina.hp.pact.meatromney.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

import java.beans.Transient

import com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY

@JsonIgnoreProperties(ignoreUnknown = true)
data class MeatRomneyPizza (val name: String = "", @JsonProperty(access = WRITE_ONLY) private val vegetarian: Boolean = false) {
    val isMeatRomneyApproved: Boolean
        get() = !vegetarian
}
