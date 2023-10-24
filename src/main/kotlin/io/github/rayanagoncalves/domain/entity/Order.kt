package io.github.rayanagoncalves.domain.entity

import java.math.BigDecimal
import java.time.LocalDate

data class Order(
    val id: Int,
    val client: Client,
    val orderDate: LocalDate,
    val total: BigDecimal
)