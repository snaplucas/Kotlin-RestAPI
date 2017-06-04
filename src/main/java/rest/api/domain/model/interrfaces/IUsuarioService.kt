package rest.api.domain.model.interrfaces

import rest.api.domain.model.entities.Usuario

interface IUsuarioService {

    fun obterUsuario(id: String): Usuario?

    fun adicionarUsuario(usuario: Usuario)

    fun obterTodos(): List<Usuario?>
}