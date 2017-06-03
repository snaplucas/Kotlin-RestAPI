package rest.api.entrypoints

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import rest.api.service.IUsuarioService

@RestController
class UsuarioController(val usuarioService: IUsuarioService) {

    @GetMapping("/hello")
    fun hello() = "Hello user!"

    @GetMapping("/obterusuario")
    fun obterUsuario() = usuarioService.obterUsuario()
}