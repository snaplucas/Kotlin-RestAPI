package rest.api.domain.model.interfaces

import rest.api.domain.model.entities.Produto

interface IProdutoService {

    fun salvar(produto: Produto): Produto

    fun obterPorId(id: Long): Produto?
}