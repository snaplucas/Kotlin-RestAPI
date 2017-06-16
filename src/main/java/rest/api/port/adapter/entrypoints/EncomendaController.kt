package rest.api.port.adapter.entrypoints

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import rest.api.application.interfaces.IEncomendaAppService
import rest.api.domain.model.entities.Encomenda

@RestController("/encomenda")
class EncomendaController(val encomendaAppService: IEncomendaAppService) {

    @PostMapping("/enviar/{fila}")
    fun enviarEncomanda(@PathVariable fila: String, @RequestBody encomenda: Encomenda) {
        encomendaAppService.enviarEncomenda(encomenda, fila)
    }
}