package io.github.rayanagoncalves.rest.dto

import java.math.BigDecimal

data class OrderDTO(
    val client: Int,
    val total: BigDecimal,
    val items: List<OrderItemDTO>
)