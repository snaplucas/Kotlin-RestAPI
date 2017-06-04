package rest.api.service

import rest.api.model.Usuario
import rest.api.repository.IUsuarioRepository

class UsuarioService(val usuarioRepository: IUsuarioRepository) : IUsuarioService {

    override fun obterUsuario(id: String) = usuarioRepository.obterUsuario(id)

    override fun adicionarUsuario(usuario: Usuario) = usuarioRepository.adicionarUsuario(usuario)

    override fun obterTodos() = usuarioRepository.obterTodos()

}