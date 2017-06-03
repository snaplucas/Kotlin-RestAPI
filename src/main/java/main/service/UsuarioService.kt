package main.service

import main.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(val usuarioRepository: UsuarioRepository) {

    fun obterUsuario() = usuarioRepository.obterUsuario()
}