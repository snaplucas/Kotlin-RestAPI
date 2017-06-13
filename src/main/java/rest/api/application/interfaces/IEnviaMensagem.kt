package rest.api.application.interfaces

interface IEnviaMensagem {

    fun enviarMensagem(queue: String, mensagem: Any)
}