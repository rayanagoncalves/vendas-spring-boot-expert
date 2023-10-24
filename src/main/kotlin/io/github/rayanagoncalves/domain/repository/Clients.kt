package io.github.rayanagoncalves.domain.repository

import io.github.rayanagoncalves.domain.entity.Client
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository


const val INSERT = "insert into client (name) values (?)"
const val SELECT_ALL = "select * from client"
const val UPDATE = "update client set name = ? where id = ?"
const val DELETE = "delete from client where id = ?"
@Repository
class Clients(
    private val jdbcTemplate: JdbcTemplate
) {

    fun save(client: Client) = jdbcTemplate.update(INSERT, client.name)

    fun update(client: Client) = jdbcTemplate.update(UPDATE, client.name, client.id)

    fun delete(id: Int) = jdbcTemplate.update(DELETE, id)

//    fun getAll(): List<Client> {
//        return jdbcTemplate.query(SELECT_ALL, getClientMapper())
//    }
//    fun findByName(name: String) = jdbcTemplate.query("$SELECT_ALL + WHERE NAME LIKE ?", "%$name%", getClientMapper())
//
//    private fun getClientMapper(): RowMapper<Client?>? {
//        return RowMapper<Client?> { resultSet, i ->
//            val id = resultSet.getInt("id")
//            val name = resultSet.getString("nome")
//            Client(id, name)
//        }
//    }

}