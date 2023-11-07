package io.github.rayanagoncalves.rest.controller

import io.github.rayanagoncalves.rest.dto.OrderDTO
import io.github.rayanagoncalves.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrderController(private val orderService: OrderService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody dto: OrderDTO): Int? {
        val order = orderService.save(dto)
        return order.id
    }
}