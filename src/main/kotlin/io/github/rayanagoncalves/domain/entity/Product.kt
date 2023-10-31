package io.github.rayanagoncalves.domain.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null

    var description: String = ""

    @Column(name = "unit_price")
    var unitPrice: BigDecimal = BigDecimal.ZERO
}