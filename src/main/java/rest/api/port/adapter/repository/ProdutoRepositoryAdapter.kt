package rest.api.port.adapter.repository

import rest.api.domain.model.entities.Produto
import rest.api.domain.model.interfaces.IProdutoRepository

class ProdutoRepositoryAdapter(val produtoRepository: ProdutoRepository) : IProdutoRepository {

    override fun obterPorId(id: Long): Produto? = produtoRepository.findOne(id)

    override fun salvar(produto: Produto) = produtoRepository.save(produto)!!
}