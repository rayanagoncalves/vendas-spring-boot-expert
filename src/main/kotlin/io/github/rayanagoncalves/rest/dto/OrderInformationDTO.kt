package io.github.rayanagoncalves.rest.dto

import java.math.BigDecimal

data class OrderInformationDTO(
    val code: Int,
    val documentNumber: String,
    val clientName: String,
    val total: BigDecimal,
    val items: List<OrderItemInformationDTO>,
    val status: String
)