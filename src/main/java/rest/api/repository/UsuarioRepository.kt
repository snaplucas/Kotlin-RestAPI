package rest.api.repository

import org.springframework.stereotype.Repository
import rest.api.model.Usuario

@Repository
class UsuarioRepository : IUsuarioRepository {

    override fun obterUsuario() = Usuario("id", "nome", 10)
}