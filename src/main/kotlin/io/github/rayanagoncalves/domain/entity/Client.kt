package io.github.rayanagoncalves.domain.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
class Client {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null

    @Column(length = 100)
    var name: String = ""

    @Column(length = 11)
    var cpf: String = ""

    @JsonIgnore
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY) // o padrao do OneToMany já é LAZY. O LAZY não traz os pedidos, só se for feito o fetch.
    // Já o EAGER sempre que carregar um cliente, carregara tambem os pedidos, deixando as consultas pesadas. Entao o recomendado é usar o LAZY.
    var orders: Set<Order> = mutableSetOf()

    override fun toString(): String {
        return "Client(id=$id, name='$name', orders=$orders)"
    }
}
