package io.github.rayanagoncalves.domain.repository

import io.github.rayanagoncalves.domain.entity.Client
import io.github.rayanagoncalves.domain.entity.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface OrderRepository: JpaRepository<Order, Int> {

    fun findByClient(client: Client): List<Order>

    @Query("select o from Order o left join fetch o.items where o.id = :id")
    fun findByIdFetchItems(@Param("id") id: Int): Order?
}