package rest.api.application.interfaces

import rest.api.domain.model.entities.Encomenda

interface IEncomendaAppService {

    fun enviarEncomenda(encomenda: Encomenda, destino: String)
}