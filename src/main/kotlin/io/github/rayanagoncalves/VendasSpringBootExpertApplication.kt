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
			val client = Client(name = "Rayana")
			clients.save(client)

			val exists = clients.existsByName("Rayana")
			println("Existe um cliente com o nome Rayana? $exists")
		}
	}
}

fun main(args: Array<String>) {
	runApplication<VendasSpringBootExpertApplication>(*args)
}
