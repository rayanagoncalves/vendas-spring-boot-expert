package io.github.rayanagoncalves

import io.github.rayanagoncalves.domain.entity.Client
import io.github.rayanagoncalves.domain.repository.ClientRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class VendasSpringBootExpertApplication {

    @Bean
    fun commandLineRunner(clients: ClientRepository): CommandLineRunner {
        return CommandLineRunner {
            val client = Client()
            client.name = "Rayana"
            clients.save(client)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<VendasSpringBootExpertApplication>(*args)
}