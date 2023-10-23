package io.github.rayanagoncalves.vendasspringbootexpert

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MyConfiguration {

    @Bean(name = ["applicationName"])
    fun applicationName(): String {
        return "Sistema de vendas"
    }

    @Bean(name = ["anotherConfiguration"])
    fun anotherConfiguration(): String {
        return "Sistema de vendas"
    }
}