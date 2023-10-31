package io.github.rayanagoncalves.domain.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
data class Order(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "client_id")
    var client: Client,

    @Column(name = "order_date")
    var orderDate: LocalDate,

    @Column(precision = 20, scale = 2)
    var total: BigDecimal,

    @OneToMany(mappedBy = "order")
    var items: List<OrderItem> = mutableListOf()
)