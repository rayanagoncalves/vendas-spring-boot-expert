package io.github.rayanagoncalves.domain.repository

import io.github.rayanagoncalves.domain.entity.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ClientRepository: JpaRepository<Client, Int> {

    @Query(value = "select * from Client c where c.name like '%:name%'", nativeQuery = true)
    fun encontrarPorNome(@Param("name") name: String): List<Client>

    fun findByNameLike(name: String): List<Client>

    @Query(value = "delete from Client c where c.name = :name")
    @Modifying
    fun deleteByName(@Param("name") name: String)

    fun existsByName(name: String): Boolean

    @Query(" select c from Client c left join fetch c.orders where c.id = :id  ")
    fun findClientFetchOrders(@Param("id") id: Int): Client
}