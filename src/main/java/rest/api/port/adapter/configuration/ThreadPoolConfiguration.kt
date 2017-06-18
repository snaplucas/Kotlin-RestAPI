package rest.api.port.adapter.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.util.concurrent.Executor


@Configuration
@EnableAsync
open class ThreadPoolConfiguration {

    @Bean(name = arrayOf("threadPoolTaskExecutor"))
    open fun threadPoolTaskExecutor(): Executor = ThreadPoolTaskExecutor()

    @Bean(name = arrayOf("anotherThreadPoool"))
    open fun anotherThreadPool(): Executor = ThreadPoolTaskExecutor()

}