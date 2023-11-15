package io.github.rayanagoncalves.domain.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.br.CPF

@Entity
class Client {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null

    @Column(length = 100)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    var name: String = ""

    @Column(name = "document_number" ,length = 11)
    @NotEmpty(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    lateinit var documentNumber: String

    @JsonIgnore
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY) // o padrao do OneToMany já é LAZY. O LAZY não traz os pedidos, só se for feito o fetch.
    // Já o EAGER sempre que carregar um cliente, carregara tambem os pedidos, deixando as consultas pesadas. Entao o recomendado é usar o LAZY.
    var orders: Set<Order> = mutableSetOf()

    override fun toString(): String {
        return "Client(id=$id, name='$name', orders=$orders)"
    }
}
