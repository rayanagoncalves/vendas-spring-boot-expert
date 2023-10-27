package io.github.rayanagoncalves.domain.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
data class Order(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int,
    @ManyToOne
    @JoinColumn(name = "client_id")
    var client: Client,
    @Column(name = "order_date")
    var orderDate: LocalDate,
    @Column(length = 20, precision = 2)
    var total: BigDecimal
)