package rest.api.application.interfaces

import org.springframework.amqp.core.Message

interface IRecebeMensagem {

    fun recebeMensagem(mensagem: Message, conversor: (String) -> Any) : Any

}