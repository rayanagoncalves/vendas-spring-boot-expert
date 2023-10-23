package io.github.rayanagoncalves.vendasspringbootexpert

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class VendasSpringBootExpertApplication(
	@Value("\${application.name}")
	private val applicationName: String
) {

	@GetMapping("/hello")
	fun helloWorld(): String {
		return applicationName
	}
}

fun main(args: Array<String>) {
	runApplication<VendasSpringBootExpertApplication>(*args)
}
