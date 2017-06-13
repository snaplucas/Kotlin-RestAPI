package rest.api.port.adapter.messaging

import org.springframework.amqp.core.Message
import rest.api.application.interfaces.IRecebeMensagem

class RecebeMensagem : IRecebeMensagem {

    override fun recebeMensagem(mensagem: Message, conversor: (String) -> Any) = conversor(String(mensagem.body))

}