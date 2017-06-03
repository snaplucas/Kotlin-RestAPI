package main.entrypoints

import main.service.UsuarioService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UsuarioController(val usuarioService: UsuarioService) {

    @GetMapping("/hello")
    fun hello() = "Hello user!"

    @GetMapping("/obterusuario")
    fun obterUsuario() = usuarioService.obterUsuario()
}