package rest.api.port.adapter.configuration

import org.springframework.amqp.core.AmqpAdmin
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import rest.api.application.services.EncomendaAppService
import rest.api.domain.model.services.ProdutoService
import rest.api.domain.model.services.UsuarioService
import rest.api.port.adapter.messaging.EnviaEncomenda
import rest.api.port.adapter.messaging.RecebeEncomenda
import rest.api.port.adapter.repository.ProdutoRepository
import rest.api.port.adapter.repository.ProdutoRepositoryAdapter
import rest.api.port.adapter.repository.UsuarioRepository

@Configuration
open class FactoryConfig(val mongoTemplate: MongoTemplate, val produtoRepository: ProdutoRepository) {

    @Autowired
    lateinit var amqpAdmin: AmqpAdmin

    @Autowired
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
    open fun getEnviaEncomenda() = EnviaEncomenda(template, amqpAdmin)

    @Bean
    open fun getRecebeEncomenda() = RecebeEncomenda()

    @Bean
    open fun getEncomandaAppService() = EncomendaAppService(getEnviaEncomenda())
}