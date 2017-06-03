package rest.api.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import rest.api.repository.UsuarioRepository
import rest.api.service.UsuarioService

@Configuration
open class FactoryConfiguration {

    @Bean
    open fun getUsuarioRepository() = UsuarioRepository()

    @Bean
    open fun getUsuarioService() = UsuarioService(getUsuarioRepository())

}