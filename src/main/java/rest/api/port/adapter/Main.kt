@file:Suppress("EXPERIMENTAL_FEATURE_WARNING")

package rest.api.port.adapter

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.jetbrains.ktor.application.Application
import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.application.install
import org.jetbrains.ktor.content.TextContent
import org.jetbrains.ktor.features.DefaultHeaders
import org.jetbrains.ktor.host.embeddedServer
import org.jetbrains.ktor.http.ContentType
import org.jetbrains.ktor.jetty.Jetty
import org.jetbrains.ktor.logging.CallLogging
import org.jetbrains.ktor.response.respondText
import org.jetbrains.ktor.routing.Routing
import org.jetbrains.ktor.routing.get
import rest.api.domain.model.entities.Produto
import rest.api.domain.model.entities.Usuario

data class Banda(val guitar: String, val bass: String, val drums: String)

fun main(args: Array<String>) {
    embeddedServer(Jetty, 8080, module = Application::module).start()
}

val gson: Gson = GsonBuilder().setPrettyPrinting().create()

fun Application.module() {
    install(DefaultHeaders)
    install(CallLogging)
    install(Routing) {
        get("/usuarios") {
            val usuario = Usuario(nome = "Mariana")
            val content = TextContent(gson.toJson(usuario), ContentType.Application.Json)
            call.respond(content)
        }
        get("/produtos") {
            call.respond(TextContent(gson.toJson(Produto(nome = "Produto", tipo = "Teste")), ContentType.Application.Json))
        }
        get("/") {
            call.respondText("""Hello, world!<br><a href="/bye">Say bye?</a>""", ContentType.Text.Html)
        }
        get("/band") {
            val band = Banda(guitar = "eddie", bass = "billy", drums = "mike")
            val content = TextContent(gson.toJson(band), ContentType.Application.Json)
            call.respond(content)
        }
    }
}

