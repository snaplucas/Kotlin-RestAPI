package rest.api.domain.model.services

import rest.api.domain.model.entities.Produto
import rest.api.domain.model.interfaces.IProdutoRepository
import rest.api.domain.model.interfaces.IProdutoService

class ProdutoService(private val produtoRepository: IProdutoRepository) : IProdutoService {
    override fun salvar(produto: Produto) = produtoRepository.salvar(produto)

    override fun obterPorId(id: Long) = produtoRepository.obterPorId(id)
}