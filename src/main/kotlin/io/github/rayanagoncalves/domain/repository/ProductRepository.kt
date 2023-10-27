package io.github.rayanagoncalves.domain.repository

import io.github.rayanagoncalves.domain.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Int>