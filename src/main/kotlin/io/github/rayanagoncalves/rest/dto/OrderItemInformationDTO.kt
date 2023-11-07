package io.github.rayanagoncalves.rest.dto

import java.math.BigDecimal

data class OrderItemInformationDTO(
    val productDescription: String,
    val unitPrice: BigDecimal,
    val quantity: Int
)