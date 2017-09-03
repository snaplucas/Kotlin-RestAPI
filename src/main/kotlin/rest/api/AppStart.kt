package rest.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
open class AppStart

fun main(args: Array<String>) {
    SpringApplication.run(AppStart::class.java)
}