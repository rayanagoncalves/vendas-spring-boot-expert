package io.github.rayanagoncalves

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean

@Development
class MyConfiguration {

    @Bean
    fun execute(): CommandLineRunner {
        return CommandLineRunner {
            println("Rodando a configuração de desenvolvimento")
        }
    }
}