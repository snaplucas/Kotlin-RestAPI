package rest.api.port.adapter.entrypoints

import org.springframework.context.annotation.Profile
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import rest.api.application.interfaces.IEncomendaAppService
import rest.api.domain.model.entities.Encomenda

@RestController("/encomenda")
@Profile("amqp")
class EncomendaController(private val encomendaAppService: IEncomendaAppService) {

    @PostMapping("/enviar/{fila}")
    fun enviarEncomenda(@PathVariable fila: String, @RequestBody encomenda: Encomenda) {
        encomendaAppService.enviarEncomenda(encomenda, fila)
    }
}