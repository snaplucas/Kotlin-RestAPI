package rest.api.service

import org.springframework.stereotype.Service
import rest.api.repository.IUsuarioRepository

@Service
class UsuarioService(val usuarioRepository: IUsuarioRepository) : IUsuarioService {

    override fun obterUsuario() = usuarioRepository.obterUsuario()
}