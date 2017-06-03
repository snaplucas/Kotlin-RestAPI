package main.repository

import main.model.Usuario
import org.springframework.stereotype.Repository

@Repository
class UsuarioRepository {

    fun obterUsuario() = Usuario("id", "nome", 10)
}