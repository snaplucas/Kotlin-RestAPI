package rest.api.domain.model.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null

    var nome: String? = null

    var tipo: String? = null
}
