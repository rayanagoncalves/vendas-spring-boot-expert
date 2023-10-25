package io.github.rayanagoncalves.domain.repository

import io.github.rayanagoncalves.domain.entity.Client
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class Clients(
    private val entityManager: EntityManager
) {

    @Transactional
    fun save(client: Client) = entityManager.persist(client)

    @Transactional
    fun update(client: Client) = entityManager.merge(client)

    @Transactional
    fun delete(client: Client) {
        if(!entityManager.contains(client)) {
            entityManager.merge(client)
        }
        entityManager.remove(client)
    }

    @Transactional
    fun delete(id: Int) {
        val client = entityManager.find(Client::class.java, id)
        entityManager.remove(client)
    }

    @Transactional(readOnly = true)
    fun findByName(name: String): List<Client> {
        val jpql = "select c from Client c where c.name like :name"
        val query = entityManager.createQuery(jpql, Client::class.java)
        query.setParameter("name", "%$name%")
        return query.resultList
    }

    @Transactional(readOnly = true)
    fun getAll(): List<Client> {
        return entityManager.createQuery("from Client", Client::class.java).resultList
    }
}