package rest.api.port.adapter.entrypoints

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import rest.api.application.interfaces.IProdutoAppService
import rest.api.domain.model.entities.Produto

@RestController("/produto")
class ProdutoController(private val produtoService: IProdutoAppService) {

    @GetMapping("/obter")
    fun obterPorId(id: Long) = produtoService.obterPorId(id)

    @PostMapping("/salvar")
    fun salvar(@RequestBody produto: Produto) = produtoService.salvar(produto)
}