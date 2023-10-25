package io.github.rayanagoncalves.domain.entity

import java.math.BigDecimal
import java.time.LocalDate

data class Order(
    var id: Int,
    var client: Client,
    var orderDate: LocalDate,
    var total: BigDecimal
)