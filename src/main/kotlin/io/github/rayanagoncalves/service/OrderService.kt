package io.github.rayanagoncalves.service

import io.github.rayanagoncalves.domain.entity.Order
import io.github.rayanagoncalves.rest.dto.OrderDTO

interface OrderService {

    fun save(orderDTO: OrderDTO): Order
}