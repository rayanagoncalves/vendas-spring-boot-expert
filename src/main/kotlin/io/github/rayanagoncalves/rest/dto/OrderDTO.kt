package io.github.rayanagoncalves.rest.dto

import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

class OrderDTO {
    @NotNull(message = "Informe o código do cliente.")
    var client: Int? = null

    @NotNull(message = "O valor total do pedido é obrigatório.")
    lateinit var total: BigDecimal

    val items: List<OrderItemDTO> = mutableListOf()
}