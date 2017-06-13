package rest.api.application.interfaces

import rest.api.domain.model.entities.Encomenda

interface IRecebeEncomenda {

    fun receberEncomenda(encomenda: Encomenda)
}