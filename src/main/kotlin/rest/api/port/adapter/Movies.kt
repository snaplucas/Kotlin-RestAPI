@file:Suppress("EXPERIMENTAL_FEATURE_WARNING")

package rest.api.port.adapter

import org.jetbrains.ktor.response.respond
import org.jetbrains.ktor.routing.Route
import org.jetbrains.ktor.routing.get

fun Route.movies() {
    get("/movie") {
        val movie = Movie()
        call.respond(movie)
    }
    get("/movies") {
        val movie1 = Movie()
        val movie2 = Movie("Blade Runner", "Science", "1982")
        val movies = listOf(movie1, movie2)
        call.respond(movies)
    }
}

data class Movie(val name: String = "Star Wars", val genre: String = "Science", val year: String = "1977")