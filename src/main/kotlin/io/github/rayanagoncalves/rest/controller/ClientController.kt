package io.github.rayanagoncalves.rest.controller

import io.github.rayanagoncalves.domain.entity.Client
import io.github.rayanagoncalves.domain.repository.ClientRepository
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/clients")
class ClientController(private val clients: ClientRepository) {

    @GetMapping("/{id}")
    @ResponseBody
    fun getClientById(@PathVariable id: Int): ResponseEntity<Client> {
        val client = clients.findById(id)

        if (client.isPresent) {
            return ResponseEntity.ok(client.get())
        }

        return ResponseEntity.notFound().build()
    }

    @PostMapping
    @ResponseBody
    fun save(@RequestBody client: Client): ResponseEntity<Client> {
        val clientSaved = clients.save(client)
        return ResponseEntity.ok(clientSaved)
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    fun delete(@PathVariable id: Int): ResponseEntity<Client> {
        val client = clients.findById(id)

        if (client.isPresent) {
            clients.delete(client.get())
            return ResponseEntity.noContent().build()
        }

        return ResponseEntity.notFound().build()
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Int,
        @RequestBody client: Client
    ): ResponseEntity<Client> {
        val clientFound = clients.findById(id)

        return clientFound.map { existingClient ->
            client.id = existingClient.id
            val updatedClient = clients.save(client)
            ResponseEntity.ok(updatedClient)
        }.orElseGet {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping
    fun find(filter: Client): ResponseEntity<List<Client>> {
        val exampleMatcher = ExampleMatcher.matching()
            .withIgnoreCase()
            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
        val example = Example.of(filter, exampleMatcher)
        val list = clients.findAll(example)
        return ResponseEntity.ok(list)
    }
}