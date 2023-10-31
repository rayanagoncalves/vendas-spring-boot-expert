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
			val rayana = Client()
			rayana.name = "Rayana"
			clientRepository.save(rayana)

			val order1 = Order()
			order1.client = rayana
			order1.orderDate = LocalDate.now()
			order1.total = BigDecimal(100)
			orderRepository.save(order1)

			val order2 = Order()
			order2.client = rayana
			order2.orderDate = LocalDate.now()
			order2.total = BigDecimal(100)
			orderRepository.save(order2)

//			val client = clientRepository.findClientFetchOrders(rayana.id!!)
//			println(client)
//			println(client.orders)

			orderRepository.findByClient(rayana).forEach { println("Código do pedido ${it.id}") }
		}
	}
}

fun main(args: Array<String>) {
	runApplication<VendasSpringBootExpertApplication>(*args)
}
