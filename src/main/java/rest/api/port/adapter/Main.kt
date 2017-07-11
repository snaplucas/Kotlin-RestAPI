package rest.api.port.adapter

import org.jetbrains.ktor.application.Application
import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.application.install
import org.jetbrains.ktor.features.Compression
import org.jetbrains.ktor.features.DefaultHeaders
import org.jetbrains.ktor.gson.GsonSupport
import org.jetbrains.ktor.host.embeddedServer
import org.jetbrains.ktor.http.ContentType
import org.jetbrains.ktor.http.HttpStatusCode
import org.jetbrains.ktor.jetty.Jetty
import org.jetbrains.ktor.logging.CallLogging
import org.jetbrains.ktor.response.respondText
import org.jetbrains.ktor.routing.get
import org.jetbrains.ktor.routing.routing
import rest.api.domain.model.entities.Produto
import rest.api.domain.model.entities.Usuario

data class Banda(val guitar: String, val bass: String, val drums: String)

fun main(args: Array<String>) {
    embeddedServer(Jetty, 8080) {
        routing {
            get("/usuarios") {
                call.respond(Usuario(nome = "Lucas", idade = 29))
            }
            get("/produtos") {
                call.respond(Produto(nome = "Produto", tipo = "Teste"))
            }
            get("/") {
                call.respondText("""Hello, world!<br><a href="/bye">Say bye?</a>""", ContentType.Text.Html)
            }
            get("/band") {
                call.respond(Banda(guitar = "eddie", bass = "billy", drums = "mike"))
            }
        }
    }.start(wait = true)
}

data class Model(val name: String, val items: List<Item>)
data class Item(val key: String, val value: String)

fun Application.main() {
    install(DefaultHeaders)
    install(Compression)
    install(CallLogging)
    install(GsonSupport) {
        setPrettyPrinting()
    }

    val model = Model("root", listOf(Item("A", "Apache"), Item("B", "Bing")))
    routing {
        get("/v1") {
            call.respond(model)
        }
        get("/v1/item/{key}") {
            val item = model.items.firstOrNull { it.key == call.parameters["key"] }
            if (item == null)
                call.respond(HttpStatusCode.NotFound)
            else
                call.respond(item)
        }
    }
}

