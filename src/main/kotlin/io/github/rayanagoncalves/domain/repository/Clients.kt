package io.github.rayanagoncalves.domain.repository

import io.github.rayanagoncalves.domain.entity.Client
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

const val INSERT = "insert into client (name) values (?)"
const val SELECT_ALL = "select * from client"
@Repository
class Clients(
    private val jdbcTemplate: JdbcTemplate
) {

    fun save(client: Client) {
        jdbcTemplate.update(INSERT, client.name)
    }
}