package io.github.rayanagoncalves.rest.dto

import java.math.BigDecimal

data class OrderInformationDTO(
    val code: Int,
    val cpf: String,
    val clientName: String,
    val total: BigDecimal,
    val items: List<OrderItemInformationDTO>
)