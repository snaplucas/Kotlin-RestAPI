package rest.api.repository

import rest.api.model.Usuario

class UsuarioRepository : IUsuarioRepository {

    override fun obterUsuario() = Usuario("id", "nome", 10)
}