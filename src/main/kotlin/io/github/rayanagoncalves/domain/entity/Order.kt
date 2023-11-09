package io.github.rayanagoncalves.domain.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
class Order {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null

    @ManyToOne
    @JoinColumn(name = "client_id")
    var client: Client? = null

    @Column(name = "order_date")
    var orderDate: LocalDate = LocalDate.now()

    @Column(precision = 20, scale = 2)
    var total: BigDecimal = BigDecimal.ZERO

    @Enumerated
    var status: OrderStatus? = null

    @OneToMany(mappedBy = "order")
    var items: List<OrderItem> = mutableListOf()


    override fun toString(): String {
        return "Order(id=$id, client=$client, orderDate=$orderDate, total=$total)"
    }
}