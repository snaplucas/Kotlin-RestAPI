package rest.api.repository

import org.springframework.data.mongodb.core.MongoTemplate
import rest.api.model.Usuario


class UsuarioRepository(val mongoTemplate: MongoTemplate) : IUsuarioRepository {

    override fun obterUsuario(id: String): Usuario? = mongoTemplate.findById(id, Usuario::class.java)

    override fun adicionarUsuario(usuario: Usuario) = mongoTemplate.save(usuario)

    override fun obterTodos(): List<Usuario?> = mongoTemplate.findAll(Usuario::class.java)
}