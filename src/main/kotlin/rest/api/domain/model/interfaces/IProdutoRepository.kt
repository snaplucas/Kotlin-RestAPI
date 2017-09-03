package rest.api.domain.model.interfaces

import rest.api.domain.model.entities.Produto

interface IProdutoRepository {

    fun salvar(produto: Produto): Produto

    fun obterPorId(id: Long): Produto?
}