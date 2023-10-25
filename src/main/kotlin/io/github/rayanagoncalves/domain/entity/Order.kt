package io.github.rayanagoncalves.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.LocalDate

@Entity
data class Order(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int,
    var client: Client,
    var orderDate: LocalDate,
    var total: BigDecimal
)