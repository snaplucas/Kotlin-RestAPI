@file:Suppress("EXPERIMENTAL_FEATURE_WARNING")

package rest.api.port.adapter

import org.jetbrains.ktor.response.respond
import org.jetbrains.ktor.routing.Route
import org.jetbrains.ktor.routing.get

fun Route.movies() {
    get("/movies") {
        val movie = Movie()
        call.respond(movie)
    }
}

data class Movie(val name: String = "Star Wars", val genre: String = "Science", val year: String = "1977")