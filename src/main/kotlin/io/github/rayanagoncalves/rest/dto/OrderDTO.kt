package io.github.rayanagoncalves.rest.dto

import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class OrderDTO(
    @NotNull(message = "Informe o código do cliente.")
    val client: Int,
    @NotNull(message = "O valor total do pedido é obrigatório.")
    val total: BigDecimal,
    val items: List<OrderItemDTO>
)