package rest.api.application.services

import rest.api.application.interfaces.IEncomendaAppService
import rest.api.application.interfaces.IEnviaEncomenda
import rest.api.domain.model.entities.Encomenda

class EncomendaAppService(private val envia: IEnviaEncomenda) : IEncomendaAppService {

    override fun enviarEncomenda(encomenda: Encomenda, destino: String) {
        envia.enviarEncomenda(queue = destino, mensagem = encomenda)
    }
}