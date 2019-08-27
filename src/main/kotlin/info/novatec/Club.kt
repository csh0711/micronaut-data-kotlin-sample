package info.novatec

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Club(
        @Id @GeneratedValue var id: Long?,
        val name: String?,
        val founded: Int?
)