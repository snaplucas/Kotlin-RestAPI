package rest.api.domain.model.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Produto(val nome: String, val tipo: String, @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Int? = null)
