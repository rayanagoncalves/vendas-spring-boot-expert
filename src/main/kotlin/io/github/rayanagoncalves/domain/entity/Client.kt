package io.github.rayanagoncalves.domain.entity

import jakarta.persistence.*

@Entity
data class Client(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = null,
    @Column(length = 100)
    var name: String
)
