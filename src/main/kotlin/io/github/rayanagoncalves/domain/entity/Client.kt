package io.github.rayanagoncalves.domain.entity

import jakarta.persistence.*

@Entity
data class Client(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null,

    @Column(length = 100)
    var name: String,

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY) // o padrao do OneToMany já é LAZY. O LAZY não traz os pedidos, só se for feito o fetch.
    // Já o EAGER sempre que carregar um cliente, carregara tambem os pedidos, deixando as consultas pesadas. Entao o recomendado é usar o LAZY.
    var orders: Set<Order> = setOf()

)
