package info.novatec

import io.micronaut.data.annotation.Query
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

@JdbcRepository(dialect = Dialect.H2)
interface FootballerRepository: CrudRepository<Footballer, Long> {

//    override fun findAll(): List<Footballer>

    fun findByPosition(position: String): List<Footballer>
}