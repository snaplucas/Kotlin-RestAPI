package rest.api.domain.model.services

import rest.api.domain.model.entities.Usuario
import rest.api.domain.model.interfaces.IUsuarioRepository
import rest.api.domain.model.interfaces.IUsuarioService

class UsuarioService(private val usuarioRepository: IUsuarioRepository) : IUsuarioService {

    override fun obterUsuario(id: String) = usuarioRepository.obterPorId(id)

    override fun adicionarUsuario(usuario: Usuario) = usuarioRepository.adicionar(usuario)

    override fun obterTodos() = usuarioRepository.obterTodos()

    override fun remover(id: String) = usuarioRepository.remover(id)
}