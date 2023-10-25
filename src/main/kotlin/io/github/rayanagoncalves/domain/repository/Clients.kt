package io.github.rayanagoncalves.domain.repository

import io.github.rayanagoncalves.domain.entity.Client
import org.springframework.data.jpa.repository.JpaRepository

interface Clients: JpaRepository<Client, Int> {

    fun findByNameLike(name: String): List<Client>

    fun existsByName(name: String): Boolean
}