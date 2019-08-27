package info.novatec

import io.micronaut.http.annotation.*
import java.util.*
import javax.validation.constraints.NotBlank

@Controller("/footballers")
open class FootballerController(
        private val footballerRepository: FootballerRepository,
        private val clubRepository: ClubRepository
) {

    @Get("/")
    fun search(@QueryValue("position") position: String?): List<Footballer> {
        return if(position != null) {
            footballerRepository.findByPosition(position)
        } else {
            footballerRepository.findAll().toList()
        }
    }

    @Get("/{id}")
    open fun findOne(@NotBlank id: Long): Optional<Footballer> {
        return footballerRepository.findById(id)
    }

    @Post("/")
    fun create(footballer: Footballer, clubId: Long?): Footballer {
        if (clubId != null) {
            clubRepository.findById(clubId).ifPresent {
                footballer.club = it
            }
        }
        return footballerRepository.save(footballer)
    }

    @Delete("/{id}")
    open fun delete(@NotBlank id: Long) {
        return footballerRepository.deleteById(id)
    }
}