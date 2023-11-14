package io.github.rayanagoncalves.rest.controller

import io.github.rayanagoncalves.domain.entity.Client
import io.github.rayanagoncalves.domain.repository.ClientRepository
import jakarta.validation.Valid
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/clients")
class ClientController(private val clients: ClientRepository) {

    @GetMapping("/{id}")
    fun getClientById(@PathVariable id: Int): Client {
        return clients.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado") }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody @Valid client: Client): Client {
        return clients.save(client)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
         clients.findById(id)
            .map { clients.delete(it) }
             .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado") }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(
        @PathVariable id: Int,
        @RequestBody client: Client
    ) {
       clients.findById(id)
           .map { client.id = it.id
           clients.save(client) }
           .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado") }
    }

    @GetMapping
    fun find(filter: Client): List<Client> {
        val exampleMatcher = ExampleMatcher.matching()
            .withIgnoreCase()
            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
        val example = Example.of(filter, exampleMatcher)
        return clients.findAll(example)
    }
}