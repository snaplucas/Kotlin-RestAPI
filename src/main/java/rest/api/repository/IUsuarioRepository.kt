package rest.api.repository

import rest.api.model.Usuario

interface IUsuarioRepository {

    fun obterUsuario(id: String): Usuario?

    fun obterTodos(): List<Usuario?>

    fun adicionarUsuario(usuario: Usuario)
}