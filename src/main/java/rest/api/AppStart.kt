package rest.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import rest.api.application.interfaces.IEnviaMensagem
import rest.api.domain.model.entities.Encomenda
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
open class AppStart : CommandLineRunner {

    @Autowired
    lateinit var enviaMensagem: IEnviaMensagem

    override fun run(vararg p0: String?) {
        enviaMensagem.enviarMensagem("encomenda", Encomenda(id = "1", tipo = "tipo", peso = 10))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(AppStart::class.java)
}