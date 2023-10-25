package io.github.rayanagoncalves.domain.entity

data class OrderItem(
    var id: Int,
    var order: Order,
    var product: Product,
    var quantity: Int
)
