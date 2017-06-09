package rest.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import rest.api.domain.model.entities.Produto
import rest.api.domain.model.interfaces.IProdutoRepository
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
open class AppStart : CommandLineRunner {

    @Autowired
    lateinit var produtoRepository: IProdutoRepository

    override fun run(vararg p0: String?) {
        val produto = Produto()
        produto.nome = "nome teste"
        produto.tipo = "tipo teste"
        produtoRepository.salvar(produto)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(AppStart::class.java)
}