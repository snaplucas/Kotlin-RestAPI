package rest.api.domain.model.interfaces

import rest.api.domain.model.entities.Usuario

interface IUsuarioRepository {

    fun obterPorId(id: String): Usuario?

    fun obterTodos(): List<Usuario?>

    fun adicionar(usuario: Usuario)

    fun remover(id: String)
}