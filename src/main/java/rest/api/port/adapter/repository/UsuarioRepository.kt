package rest.api.port.adapter.repository

import org.springframework.data.mongodb.core.MongoTemplate
import rest.api.domain.model.entities.Usuario
import rest.api.domain.model.interfaces.IUsuarioRepository


class UsuarioRepository(val mongoTemplate: MongoTemplate) : IUsuarioRepository {

    override fun obterUsuario(id: String): Usuario? = mongoTemplate.findById(id, Usuario::class.java)

    override fun adicionarUsuario(usuario: Usuario) = mongoTemplate.save(usuario)

    override fun obterTodos(): List<Usuario?> = mongoTemplate.findAll(Usuario::class.java)
}