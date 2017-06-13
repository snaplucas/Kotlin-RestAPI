package rest.api.port.adapter.messaging

import org.springframework.amqp.core.AmqpAdmin
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.amqp.core.Queue
import rest.api.application.interfaces.IEnviaMensagem

class EnviaMensagem(val template: AmqpTemplate, val amqpAdmin: AmqpAdmin) : IEnviaMensagem {

    override fun enviarMensagem(queue: String, mensagem: Any) {
        amqpAdmin.declareQueue(Queue(queue))
        template.convertAndSend(queue, mensagem)
    }
}