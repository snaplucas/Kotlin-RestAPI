package rest.api.port.adapter.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import rest.api.domain.model.services.UsuarioService
import rest.api.port.adapter.repository.ProdutoRepository
import rest.api.port.adapter.repository.ProdutoRepositoryAdapter
import rest.api.port.adapter.repository.UsuarioRepository

@Configuration
open class FactoryConfig(val mongoTemplate: MongoTemplate, val produtoRepository: ProdutoRepository) {

    @Bean
    open fun getUsuarioRepository() = UsuarioRepository(mongoTemplate)

    @Bean
    open fun getUsuarioService() = UsuarioService(getUsuarioRepository())

    @Bean
    open fun getProdutoRepository() = ProdutoRepositoryAdapter(produtoRepository)
}