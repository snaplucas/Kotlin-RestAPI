package rest.api.port.adapter.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor


@Configuration
@EnableAsync
open class ThreadPoolConfig {

    @Bean(name = ["threadPoolTaskExecutor"])
    open fun threadPoolTaskExecutor(): Executor = ThreadPoolTaskExecutor()

    @Bean(name = ["anotherThreadPoool"])
    open fun anotherThreadPool(): Executor = ThreadPoolTaskExecutor()

}