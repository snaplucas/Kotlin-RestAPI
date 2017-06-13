package rest.api.application.interfaces

interface IEnviaEncomenda {

    fun enviarEncomenda(queue: String, mensagem: Any)
}