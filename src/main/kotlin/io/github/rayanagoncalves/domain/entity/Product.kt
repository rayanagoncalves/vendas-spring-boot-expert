package io.github.rayanagoncalves.domain.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int,
    var description: String,
    @Column(name = "unit_price")
    var unitPrice: BigDecimal
)