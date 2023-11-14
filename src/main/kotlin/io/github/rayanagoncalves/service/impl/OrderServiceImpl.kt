package io.github.rayanagoncalves.service.impl

import io.github.rayanagoncalves.domain.entity.Order
import io.github.rayanagoncalves.domain.entity.OrderItem
import io.github.rayanagoncalves.domain.entity.OrderStatus
import io.github.rayanagoncalves.domain.repository.ClientRepository
import io.github.rayanagoncalves.domain.repository.OrderItemRepository
import io.github.rayanagoncalves.domain.repository.OrderRepository
import io.github.rayanagoncalves.domain.repository.ProductRepository
import io.github.rayanagoncalves.exception.BusinessRuleException
import io.github.rayanagoncalves.exception.OrderNotFoundException
import io.github.rayanagoncalves.rest.dto.OrderDTO
import io.github.rayanagoncalves.rest.dto.OrderItemDTO
import io.github.rayanagoncalves.service.OrderService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class OrderServiceImpl(
    private val clients: ClientRepository,
    private val products: ProductRepository,
    private val orderItems: OrderItemRepository,
    private val orders: OrderRepository
) : OrderService {

    @Transactional
    override fun save(dto: OrderDTO): Order {
        val order = Order()
        order.total = dto.total
        order.orderDate = LocalDate.now()
        val client = dto.client?.let { clients.findById(it).orElseThrow { BusinessRuleException("Código inválido.") } }
        order.client = client
        order.status = OrderStatus.REALIZADO

        val items = saveItems(order, dto.items)
        orders.save(order)
        orderItems.saveAll(items)
        order.items = items

        return order
    }

    override fun getCompleteOrder(id: Int): Order? {
        return orders.findByIdFetchItems(id)
    }

    @Transactional
    override fun updateStatus(id: Int, orderStatus: OrderStatus) {
        orders.findById(id)
            .map {
                it.status = orderStatus
                orders.save(it)
            }.orElseThrow { OrderNotFoundException() }
    }

    private fun saveItems(order: Order, items: List<OrderItemDTO>): List<OrderItem> {
        if (items.isEmpty()) {
            throw BusinessRuleException("Não é possível lançar um pedido sem itens.")
        }

       return items.stream().map {
           return@map createOrderItem(it, order)
       }.toList()
    }

    private fun createOrderItem(it: OrderItemDTO, order: Order): OrderItem {
        val product = products.findById(it.product)
            .orElseThrow { BusinessRuleException("Código de produto inválido: ${it.product}") }
        val orderItem = OrderItem()
        orderItem.quantity = it.quantity
        orderItem.order = order
        orderItem.product = product
        return orderItem
    }
}