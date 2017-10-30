package rest.api.application.interfaces

import rest.api.domain.model.entities.Produto

interface IProdutoAppService {

    fun salvar(produto: Produto): Produto

    fun obterPorId(id: Long): Produto?
}