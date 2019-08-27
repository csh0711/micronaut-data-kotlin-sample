package info.novatec

import javax.persistence.*

@Entity
data class Footballer(
        @Id @GeneratedValue var id: Long?,
        val firstName: String?,
        val lastName: String?,
        val position: String?,
        @ManyToOne
        var club: Club?
)