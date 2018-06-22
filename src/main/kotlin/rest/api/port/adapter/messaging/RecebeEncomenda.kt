package rest.api.port.adapter.messaging

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import rest.api.application.interfaces.IRecebeEncomenda
import rest.api.domain.model.entities.Encomenda

@Component
class RecebeEncomenda : IRecebeEncomenda {

    @Async
    @RabbitListener(queues = ["encomenda"], containerFactory = "rabbitListenerContainerFactory")
    override fun receberEncomenda(encomenda: Encomenda) {
        try {
            println(encomenda)
            println("Preco da encomenda: " + encomenda.preco)
            println("Preco com desconto:" + encomenda.calcularDesconto({ x -> x * 0.9 }))
        } catch(e: Exception) {
            println(e.message)
        }
    }
}