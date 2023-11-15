package io.github.rayanagoncalves.rest.dto

import io.github.rayanagoncalves.validation.NotEmptyList
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

class OrderDTO {
    @NotNull(message = "Informe o código do cliente.")
    var client: Int? = null

    @NotNull(message = "O valor total do pedido é obrigatório.")
    lateinit var total: BigDecimal

    @NotEmptyList(message = "Pedido não pode ser realizado sem itens.")
    val items: List<OrderItemDTO> = mutableListOf()
}