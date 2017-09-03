package rest.api.domain.model.interfaces

import rest.api.domain.model.entities.Usuario

interface IUsuarioService {

    fun obterUsuario(id: String): Usuario?

    fun adicionarUsuario(usuario: Usuario)

    fun obterTodos(): List<Usuario?>

    fun remover(id: String)
}