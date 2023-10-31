package io.github.rayanagoncalves

import io.github.rayanagoncalves.domain.entity.Client
import io.github.rayanagoncalves.domain.entity.Order
import io.github.rayanagoncalves.domain.repository.ClientRepository
import io.github.rayanagoncalves.domain.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.math.BigDecimal
import java.time.LocalDate

@SpringBootApplication
class VendasSpringBootExpertApplication() {

	@Bean
	fun init(@Autowired clientRepository: ClientRepository, @Autowired orderRepository: OrderRepository): CommandLineRunner {
		return CommandLineRunner {
			val client = Client(name = "Rayana")
			clientRepository.save(client)

			val exists = clientRepository.existsByName("Rayana")
			println("Existe um cliente com o nome Rayana? $exists")

			val result = clientRepository.encontrarPorNome("Rayana")
			result.forEach { println(it) }

			val o = Order(client = client, orderDate = LocalDate.now(), total = BigDecimal(100))
			orderRepository.save(o)

			clientRepository.findClientFetchOrders(client.id!!)
			println(client)
			println(client.orders)

		}
	}
}

fun main(args: Array<String>) {
	runApplication<VendasSpringBootExpertApplication>(*args)
}
