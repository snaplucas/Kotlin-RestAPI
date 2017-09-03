package rest.api.port.adapter.messaging

import org.springframework.amqp.core.AmqpAdmin
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.amqp.core.Queue
import rest.api.application.interfaces.IEnviaEncomenda

class EnviaEncomenda(val template: AmqpTemplate, val amqpAdmin: AmqpAdmin) : IEnviaEncomenda {

    override fun enviarEncomenda(queue: String, mensagem: Any) {
        amqpAdmin.declareQueue(Queue(queue))
        template.convertAndSend(queue, mensagem)
    }
}