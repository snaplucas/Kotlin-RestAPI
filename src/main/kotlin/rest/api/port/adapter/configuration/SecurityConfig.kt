package rest.api.port.adapter.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
open class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Value("\${security.user.name}")
    private val username: String? = null
    @Value("\${security.user.password}")
    private val password: String? = null

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests().antMatchers("/", "/info", "/eureka/**", "/swagger-ui.html", "/webjars/**",
                "/swagger-resources/**", "/v2/**").permitAll().anyRequest().authenticated().and().httpBasic()
        http.x509().and().headers().xssProtection().and().and().csrf().disable()
    }
}