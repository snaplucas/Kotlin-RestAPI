package rest.api.port.adapter.messaging

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import rest.api.application.interfaces.IRecebeEncomenda
import rest.api.domain.model.entities.Encomenda

@Component
class RecebeEncomenda : IRecebeEncomenda {

    @Async
    @RabbitListener(queues = arrayOf("encomenda"), containerFactory = "rabbitListenerContainerFactory")
    override fun receberEncomenda(encomenda: Encomenda) {
        try {
            println(encomenda)
        } catch(e: Exception) {
            println(e.message)
        }
    }
}