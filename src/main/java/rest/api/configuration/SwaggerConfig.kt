package rest.api.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType.SWAGGER_2
import springfox.documentation.spring.web.plugins.Docket

@Configuration
open class SwaggerConfig {

    @Bean
    open fun configSwagger() = Docket(SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("rest.api.entrypoints"))
            .paths(PathSelectors.any())
            .build()!!
}