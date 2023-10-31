package io.github.rayanagoncalves.domain.entity

import jakarta.persistence.*

@Entity
class OrderItem {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null

    @ManyToOne
    @JoinColumn(name = "order_id")
    var order: Order? = null

    @ManyToOne
    @JoinColumn(name = "product_id")
    var product: Product? = null

    var quantity: Int = 0
}
