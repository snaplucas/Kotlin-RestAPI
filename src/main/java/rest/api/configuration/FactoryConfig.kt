package rest.api.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import rest.api.repository.UsuarioRepository
import rest.api.service.UsuarioService

@Configuration
open class FactoryConfig(val mongoTemplate: MongoTemplate) {

    @Bean
    open fun getUsuarioRepository() = UsuarioRepository(mongoTemplate)

    @Bean
    open fun getUsuarioService() = UsuarioService(getUsuarioRepository())

}