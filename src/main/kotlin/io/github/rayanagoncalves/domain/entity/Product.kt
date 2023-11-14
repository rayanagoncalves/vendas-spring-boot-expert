package io.github.rayanagoncalves.domain.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

@Entity
class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null

    @Column(length = 150)
    @NotEmpty(message = "A descrição é obrigatória.")
    var description: String = ""

    @Column(name = "unit_price")
    @NotNull(message = "O preço é obrigatório.")
    lateinit var unitPrice: BigDecimal
}