package rest.api.port.adapter.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import rest.api.port.adapter.repository.UsuarioRepository
import rest.api.domain.model.services.UsuarioService

@Configuration
open class FactoryConfig(val mongoTemplate: MongoTemplate) {

    @Bean
    open fun getUsuarioRepository() = UsuarioRepository(mongoTemplate)

    @Bean
    open fun getUsuarioService() = UsuarioService(getUsuarioRepository())

}