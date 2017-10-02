package rest.api.port.adapter.entrypoints

import org.springframework.web.bind.annotation.*
import rest.api.domain.model.entities.Usuario
import rest.api.domain.model.interfaces.IUsuarioService
import java.lang.RuntimeException
import java.util.concurrent.TimeoutException

@RestController("/usuario")
class UsuarioController(private val usuarioService: IUsuarioService) {

    @GetMapping("/obterusuario")
    fun obterUsuario(id: String) = usuarioService.obterUsuario(id)

    @GetMapping("/obtertodos")
    fun obterTodos() = usuarioService.obterTodos()

    @PostMapping("/adicionar")
    fun adicionarUsuario(@RequestBody usuario: Usuario) = usuarioService.adicionarUsuario(usuario)

    @PostMapping("/remover")
    fun removerUsuario(@RequestParam id: String) = usuarioService.remover(id)

    @GetMapping("/excecao/runtime")
    fun capturaRutimeException(): Nothing = throw RuntimeException()

    @GetMapping("/excecao/timeout")
    fun capturaTimeoutException(): Nothing = throw TimeoutException()
}