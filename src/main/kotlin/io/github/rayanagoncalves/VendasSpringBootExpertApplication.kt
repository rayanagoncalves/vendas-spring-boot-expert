package io.github.rayanagoncalves

import io.github.rayanagoncalves.domain.entity.Client
import io.github.rayanagoncalves.domain.repository.Clients
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class VendasSpringBootExpertApplication {

	@Bean
	fun init(@Autowired clients: Clients): CommandLineRunner {
		return CommandLineRunner {
			val client = Client("Rayana")
			clients.save(client = client)
		}
	}
}

fun main(args: Array<String>) {
	runApplication<VendasSpringBootExpertApplication>(*args)
}
