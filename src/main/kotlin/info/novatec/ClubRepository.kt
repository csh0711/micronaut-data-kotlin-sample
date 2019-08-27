package info.novatec

import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

@JdbcRepository(dialect = Dialect.H2)
interface ClubRepository: CrudRepository<Club, Long> {

    override fun findAll(): List<Club>
}