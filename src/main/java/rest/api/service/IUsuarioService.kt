package rest.api.service

import rest.api.model.Usuario

interface IUsuarioService {

    fun obterUsuario(): Usuario
}