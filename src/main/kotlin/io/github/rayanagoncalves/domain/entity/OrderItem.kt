package io.github.rayanagoncalves.domain.entity

import jakarta.persistence.*

@Entity
data class OrderItem(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "order_id")
    var order: Order,

    @ManyToOne
    @JoinColumn(name = "product_id")
    var product: Product,

    var quantity: Int
)
