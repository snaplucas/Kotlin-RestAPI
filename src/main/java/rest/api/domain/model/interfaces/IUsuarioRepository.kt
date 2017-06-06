package rest.api.domain.model.interfaces

import rest.api.domain.model.entities.Usuario

interface IUsuarioRepository {

    fun obterUsuario(id: String): Usuario?

    fun obterTodos(): List<Usuario?>

    fun adicionarUsuario(usuario: Usuario)
}