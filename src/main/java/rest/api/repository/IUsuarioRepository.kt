package rest.api.repository

import rest.api.model.Usuario

interface IUsuarioRepository {

    fun obterUsuario(): Usuario
}