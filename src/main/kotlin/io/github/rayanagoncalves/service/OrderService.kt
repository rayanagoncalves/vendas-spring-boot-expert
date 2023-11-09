package io.github.rayanagoncalves.service

import io.github.rayanagoncalves.domain.entity.Order
import io.github.rayanagoncalves.domain.entity.OrderStatus
import io.github.rayanagoncalves.rest.dto.OrderDTO

interface OrderService {

    fun save(orderDTO: OrderDTO): Order

    fun getCompleteOrder(id: Int): Order?

    fun updateStatus(id: Int, orderStatus: OrderStatus)
}