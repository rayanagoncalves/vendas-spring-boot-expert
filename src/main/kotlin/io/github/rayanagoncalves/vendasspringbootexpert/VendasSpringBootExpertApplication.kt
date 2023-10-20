package io.github.rayanagoncalves.vendasspringbootexpert

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class VendasSpringBootExpertApplication {

	@GetMapping("/hello")
	fun helloWorld(): String {
		return "Hello World!"
	}
}

fun main(args: Array<String>) {
	runApplication<VendasSpringBootExpertApplication>(*args)
}
