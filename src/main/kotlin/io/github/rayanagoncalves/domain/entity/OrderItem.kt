package io.github.rayanagoncalves.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class OrderItem(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int,
    var order: Order,
    var product: Product,
    var quantity: Int
)
