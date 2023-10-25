package io.github.rayanagoncalves.domain.entity

import java.math.BigDecimal

data class Product(
    var id: Int,
    var description: String,
    var price: BigDecimal
)