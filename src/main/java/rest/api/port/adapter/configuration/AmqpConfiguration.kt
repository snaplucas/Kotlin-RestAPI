package rest.api.port.adapter.configuration

import org.springframework.amqp.core.AmqpAdmin
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableRabbit
open class AmqpConfiguration(val amqpAdmin: AmqpAdmin) {

    @Value("\${amqp.connectionFactory.host}")
    lateinit var host: String

    @Value("\${amqp.connectionFactory.username}")
    lateinit var username: String

    @Value("\${amqp.connectionFactory.password}")
    lateinit var password: String

    @Bean
    open fun rabbitConnectionFactory(): ConnectionFactory {
        val connectionFactory = CachingConnectionFactory(host)
        connectionFactory.username = username
        connectionFactory.setPassword(password)
        return connectionFactory
    }

    @Bean
    open fun rabbitListenerContainerFactory(): SimpleRabbitListenerContainerFactory {
        val factory = SimpleRabbitListenerContainerFactory()
        factory.setConnectionFactory(rabbitConnectionFactory())
        factory.setConcurrentConsumers(3)
        factory.setMaxConcurrentConsumers(10)
        amqpAdmin.declareQueue(Queue("teste"))
        return factory
    }
}