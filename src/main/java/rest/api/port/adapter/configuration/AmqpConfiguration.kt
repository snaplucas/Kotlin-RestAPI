package rest.api.port.adapter.configuration

import org.springframework.amqp.core.AmqpAdmin
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableRabbit
open class AmqpConfiguration {

    @Autowired
    lateinit var amqpAdmin: AmqpAdmin

    @Bean
    open fun rabbitConnectionFactory(): ConnectionFactory {
        val connectionFactory = CachingConnectionFactory("192.168.99.100")
        connectionFactory.username = "guest"
        connectionFactory.setPassword("guest")
        return connectionFactory
    }

    @Bean
    open fun rabbitListenerContainerFactory(): SimpleRabbitListenerContainerFactory {
        val factory = SimpleRabbitListenerContainerFactory()
        factory.setConnectionFactory(rabbitConnectionFactory())
        factory.setConcurrentConsumers(3)
        factory.setMaxConcurrentConsumers(10)
        amqpAdmin.declareQueue(Queue("encomenda"))
        return factory
    }
}