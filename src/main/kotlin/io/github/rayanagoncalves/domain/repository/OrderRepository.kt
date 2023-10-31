package io.github.rayanagoncalves.domain.repository

import io.github.rayanagoncalves.domain.entity.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, Int>