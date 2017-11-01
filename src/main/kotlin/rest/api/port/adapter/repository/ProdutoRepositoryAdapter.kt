package rest.api.port.adapter.repository

import rest.api.domain.model.entities.Produto
import rest.api.domain.model.interfaces.IProdutoRepository
import javax.persistence.PersistenceException

class ProdutoRepositoryAdapter(private val produtoRepository: ProdutoRepository) : IProdutoRepository {

    override fun obterPorId(id: Long): Produto? = produtoRepository.findOne(id)

    override fun salvar(produto: Produto): Produto = try { produtoRepository.save(produto) } catch (e: Exception) { throw PersistenceException(e) }
}