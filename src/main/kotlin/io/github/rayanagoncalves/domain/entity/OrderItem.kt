package io.github.rayanagoncalves.domain.entity

data class OrderItem(
    val id: Int,
    val order: Order,
    val product: Product,
    val quantity: Int
)
