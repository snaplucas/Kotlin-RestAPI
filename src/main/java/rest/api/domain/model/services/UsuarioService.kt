package rest.api.domain.model.services

import rest.api.domain.model.entities.Usuario
import rest.api.domain.model.interfaces.IUsuarioRepository
import rest.api.domain.model.interfaces.IUsuarioService

class UsuarioService(val usuarioRepository: IUsuarioRepository) : IUsuarioService {

    override fun obterUsuario(id: String) = usuarioRepository.obterUsuario(id)

    override fun adicionarUsuario(usuario: Usuario) = usuarioRepository.adicionarUsuario(usuario)

    override fun obterTodos() = usuarioRepository.obterTodos()

}