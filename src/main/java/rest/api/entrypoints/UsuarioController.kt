package rest.api.entrypoints

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import rest.api.model.Usuario
import rest.api.service.IUsuarioService

@RestController
class UsuarioController(val usuarioService: IUsuarioService) {

    @GetMapping("/obterusuario")
    fun obterUsuario(id: String) = usuarioService.obterUsuario(id)

    @GetMapping("/obtertodos")
    fun obterTodos() = usuarioService.obterTodos()

    @PostMapping("/adicionar")
    fun adicionarUsuario(@RequestBody usuario: Usuario) = usuarioService.adicionarUsuario(usuario)
}