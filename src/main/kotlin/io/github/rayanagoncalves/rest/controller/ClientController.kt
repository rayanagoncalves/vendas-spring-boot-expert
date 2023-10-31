package io.github.rayanagoncalves.rest.controller

import io.github.rayanagoncalves.domain.entity.Client
import io.github.rayanagoncalves.domain.repository.ClientRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ClientController(private val clients: ClientRepository) {

    @GetMapping("/api/clients/{id}")
    @ResponseBody
    fun getClientById(@PathVariable id: Int): ResponseEntity<Client> {
        val client = clients.findById(id)

        if(client.isPresent) {
            return ResponseEntity.ok(client.get())
        }

        return ResponseEntity.notFound().build()
    }
}