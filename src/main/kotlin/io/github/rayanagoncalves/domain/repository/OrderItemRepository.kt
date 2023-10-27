package io.github.rayanagoncalves.domain.repository

import io.github.rayanagoncalves.domain.entity.OrderItem
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository: JpaRepository<OrderItem, Int>