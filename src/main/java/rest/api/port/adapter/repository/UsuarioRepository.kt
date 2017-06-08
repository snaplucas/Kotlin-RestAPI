package rest.api.port.adapter.repository

import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import rest.api.domain.model.entities.Usuario
import rest.api.domain.model.interfaces.IUsuarioRepository


class UsuarioRepository(val mongoTemplate: MongoTemplate) : IUsuarioRepository {

    override fun obterPorId(id: String): Usuario? = mongoTemplate.findById(id, Usuario::class.java)

    override fun adicionar(usuario: Usuario) = mongoTemplate.save(usuario)

    override fun obterTodos(): List<Usuario?> = mongoTemplate.findAll(Usuario::class.java)

    override fun remover(id: String): Unit {
        mongoTemplate.findAndRemove(Query(Criteria.where("_id").`is`(id)), Usuario::class.java)
    }
}