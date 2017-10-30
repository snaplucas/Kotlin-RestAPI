package rest.api.application.services

import rest.api.application.exceptions.EntityNotFoundException
import rest.api.application.interfaces.IProdutoAppService
import rest.api.domain.model.entities.Produto
import rest.api.domain.model.interfaces.IProdutoService

class ProdutoAppService(private val produtoService: IProdutoService) : IProdutoAppService {

    override fun salvar(produto: Produto): Produto = produtoService.salvar(produto)

    override fun obterPorId(id: Long): Produto? = produtoService.obterPorId(id) ?: throw EntityNotFoundException("Produto nao encontrado")
}