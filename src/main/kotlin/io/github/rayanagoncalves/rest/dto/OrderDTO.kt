package io.github.rayanagoncalves.rest.dto

import io.github.rayanagoncalves.validation.NotEmptyList
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

class OrderDTO {
    @NotNull(message = "{campo.codigo-cliente.obrigatorio}")
    var client: Int? = null

    @NotNull(message = "{campo.total-pedido.obrigatorio}")
    lateinit var total: BigDecimal

    @NotEmptyList(message = "{campo.items-pedido.obrigatorio}")
    val items: List<OrderItemDTO> = mutableListOf()
}