package io.github.rayanagoncalves.vendasspringbootexpert

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("prd")
class MyConfiguration {

    @Bean
    fun execute(): CommandLineRunner {
        return CommandLineRunner {
            println("Rodando a configuração de produção")
        }
    }
}