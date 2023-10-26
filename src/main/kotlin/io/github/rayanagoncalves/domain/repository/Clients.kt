package io.github.rayanagoncalves.domain.repository

import io.github.rayanagoncalves.domain.entity.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface Clients: JpaRepository<Client, Int> {

    @Query(value = "select c from Client c where c.name like :name")
    fun encontrarPorNome(@Param("name") name: String): List<Client>
    fun findByNameLike(name: String): List<Client>

    fun existsByName(name: String): Boolean
}