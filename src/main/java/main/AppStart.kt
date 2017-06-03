package main

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class AppStart {
    fun main(args: Array<String>) {
        SpringApplication.run(AppStart::class)
    }
}