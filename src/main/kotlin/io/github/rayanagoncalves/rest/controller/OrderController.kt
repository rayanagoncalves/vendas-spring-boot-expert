package io.github.rayanagoncalves.rest.controller

import io.github.rayanagoncalves.domain.entity.Order
import io.github.rayanagoncalves.domain.entity.OrderItem
import io.github.rayanagoncalves.rest.dto.OrderDTO
import io.github.rayanagoncalves.rest.dto.OrderInformationDTO
import io.github.rayanagoncalves.rest.dto.OrderItemInformationDTO
import io.github.rayanagoncalves.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/orders")
class OrderController(private val orderService: OrderService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody dto: OrderDTO): Int? {
        val order = orderService.save(dto)
        return order.id
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): OrderInformationDTO {
        val completedOrder = orderService.getCompleteOrder(id)
        return convert(completedOrder!!)
    }

    private fun convert(order: Order): OrderInformationDTO {
        return OrderInformationDTO(
            code = order.id!!,
            clientName = order.client!!.name,
            documentNumber = order.client!!.documentNumber,
            total = order.total,
            items = convert(order.items),
            status = order.status!!.name
        )
    }

    private fun convert(items: List<OrderItem>): List<OrderItemInformationDTO> {
        if(items.isEmpty()) {
            return Collections.emptyList()
        }

        return items.stream().map {
            OrderItemInformationDTO(
                productDescription = it.product!!.description,
                unitPrice = it.product!!.unitPrice,
                quantity = it.quantity
            )
        }.toList()
    }
}