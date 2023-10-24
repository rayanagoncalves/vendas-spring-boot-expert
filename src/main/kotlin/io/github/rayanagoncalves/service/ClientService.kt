package io.github.rayanagoncalves.service

import io.github.rayanagoncalves.model.Client
import io.github.rayanagoncalves.repository.ClientRepository
import org.springframework.stereotype.Service

@Service
class ClientService(
    private val clientRepository: ClientRepository
) {

    fun saveClient(client: Client) {
        validateClient(client)
        clientRepository.persist(client)
    }

    private fun validateClient(client: Client) {

    }
}