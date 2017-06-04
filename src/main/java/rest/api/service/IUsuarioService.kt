package rest.api.service

import rest.api.model.Usuario

interface IUsuarioService {

    fun obterUsuario(id: String): Usuario?

    fun adicionarUsuario(usuario: Usuario)

    fun obterTodos(): List<Usuario?>
}