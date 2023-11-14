package io.github.rayanagoncalves.rest.controller

import io.github.rayanagoncalves.domain.entity.Product
import io.github.rayanagoncalves.domain.repository.ProductRepository
import jakarta.validation.Valid
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/products")
class ProductController(
    private val products: ProductRepository
) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): Product {
        return products.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado") }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid product: Product): Product {
        return products.save(product)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        products.findById(id)
            .map { products.delete(it) }
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado") }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int,
               @RequestBody @Valid product: Product
    ) {
        products.findById(id)
            .map { product.id = it.id
            products.save(product) }
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado") }
    }

    @GetMapping
    fun find(filter: Product): List<Product> {
        val exampleMatcher = ExampleMatcher.matching()
            .withIgnoreCase()
            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
        val example = Example.of(filter, exampleMatcher)
        return products.findAll(example)
    }
}