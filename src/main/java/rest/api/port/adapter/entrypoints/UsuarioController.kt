package rest.api.port.adapter.entrypoints

import org.springframework.web.bind.annotation.*
import rest.api.domain.model.entities.Usuario
import rest.api.domain.model.interfaces.IUsuarioService

@RestController("/usuario")
class UsuarioController(val usuarioService: IUsuarioService) {

    @GetMapping("/obterusuario")
    fun obterUsuario(id: String) = usuarioService.obterUsuario(id)

    @GetMapping("/obtertodos")
    fun obterTodos() = usuarioService.obterTodos()

    @PostMapping("/adicionar")
    fun adicionarUsuario(@RequestBody usuario: Usuario) = usuarioService.adicionarUsuario(usuario)

    @PostMapping("/remover")
    fun removerUsuario(@RequestParam id: String) = usuarioService.remover(id)
}