package io.github.rayanagoncalves.rest.controller

import io.github.rayanagoncalves.domain.entity.Client
import io.github.rayanagoncalves.domain.repository.ClientRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/clients")
class ClientController(private val clients: ClientRepository) {

    @GetMapping("/{id}")
    @ResponseBody
    fun getClientById(@PathVariable id: Int): ResponseEntity<Client> {
        val client = clients.findById(id)

        if(client.isPresent) {
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
}