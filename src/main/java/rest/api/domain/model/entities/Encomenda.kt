package rest.api.domain.model.entities

import java.io.Serializable

data class Encomenda(val id: String, val tipo: String, val peso: Int) : Serializable