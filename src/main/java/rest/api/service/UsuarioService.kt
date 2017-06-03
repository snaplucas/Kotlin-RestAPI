package rest.api.service

import rest.api.repository.IUsuarioRepository

class UsuarioService(val usuarioRepository: IUsuarioRepository) : IUsuarioService {

    override fun obterUsuario() = usuarioRepository.obterUsuario()
}