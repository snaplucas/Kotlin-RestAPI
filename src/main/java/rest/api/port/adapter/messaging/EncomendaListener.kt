package rest.api.port.adapter.messaging

import com.google.gson.Gson
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import rest.api.domain.model.entities.Encomenda

@Component
class EncomendaListener(val recebeMensagem: RecebeMensagem) {

    @Async
    @RabbitListener(queues = arrayOf("encomenda"), containerFactory = "rabbitListenerContainerFactory")
    fun handler(message: Message) {
        try {
            val encomenda = recebeMensagem.recebeMensagem(message, { json -> Gson().fromJson(json, Encomenda::class.java) })
            println(encomenda)
        } catch(e: Exception) {
        }
    }
}