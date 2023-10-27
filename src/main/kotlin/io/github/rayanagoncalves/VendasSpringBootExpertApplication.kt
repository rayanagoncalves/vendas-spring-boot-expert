package io.github.rayanagoncalves

import io.github.rayanagoncalves.domain.entity.Client
import io.github.rayanagoncalves.domain.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class VendasSpringBootExpertApplication {

	@Bean
	fun init(@Autowired clientRepository: ClientRepository): CommandLineRunner {
		return CommandLineRunner {
			val client = Client(name = "Rayana")
			clientRepository.save(client)

			val exists = clientRepository.existsByName("Rayana")
			println("Existe um cliente com o nome Rayana? $exists")

			val result = clientRepository.encontrarPorNome("Rayana")
			result.forEach { println(it) }
		}
	}
}

fun main(args: Array<String>) {
	runApplication<VendasSpringBootExpertApplication>(*args)
}
