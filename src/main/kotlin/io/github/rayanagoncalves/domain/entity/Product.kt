package io.github.rayanagoncalves.domain.entity

import java.math.BigDecimal

data class Product(
    val id: Int,
    val description: String,
    val price: BigDecimal
)