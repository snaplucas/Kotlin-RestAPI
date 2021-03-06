package rest.api.port.adapter.configuration

import org.springframework.amqp.core.AmqpAdmin
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.data.mongodb.core.MongoTemplate
import rest.api.application.services.EncomendaAppService
import rest.api.application.services.ProdutoAppService
import rest.api.domain.model.services.ProdutoService
import rest.api.domain.model.services.UsuarioService
import rest.api.port.adapter.messaging.EnviaEncomenda
import rest.api.port.adapter.messaging.RecebeEncomenda
import rest.api.port.adapter.repository.ProdutoRepository
import rest.api.port.adapter.repository.ProdutoRepositoryAdapter
import rest.api.port.adapter.repository.UsuarioRepository

@Configuration
open class FactoryConfig(private val mongoTemplate: MongoTemplate, private val produtoRepository: ProdutoRepository) {

    @Autowired private
    lateinit var amqpAdmin: AmqpAdmin

    @Autowired private
    lateinit var template: AmqpTemplate

    @Bean
    open fun getUsuarioRepository() = UsuarioRepository(mongoTemplate)

    @Bean
    open fun getUsuarioService() = UsuarioService(getUsuarioRepository())

    @Bean
    open fun getProdutoRepository() = ProdutoRepositoryAdapter(produtoRepository)

    @Bean
    open fun getProdutoService() = ProdutoService(getProdutoRepository())

    @Bean
    open fun getProdutoAppService() = ProdutoAppService(getProdutoService())

    @Bean
    @Profile("amqp")
    open fun getEnviaEncomenda() = EnviaEncomenda(template, amqpAdmin)

    @Bean
    @Profile("amqp")
    open fun getRecebeEncomenda() = RecebeEncomenda()

    @Bean
    @Profile("amqp")
    open fun getEncomendaAppService() = EncomendaAppService(getEnviaEncomenda())
}