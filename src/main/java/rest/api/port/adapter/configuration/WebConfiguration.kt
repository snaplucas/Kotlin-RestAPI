package rest.api.port.adapter.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
@EnableWebMvc
open class WebConfiguration : WebMvcConfigurerAdapter() {

    override fun addCorsMappings(registry: CorsRegistry?) {
        registry!!.addMapping("/**")
    }
}