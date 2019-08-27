package info.novatec

import io.micronaut.http.annotation.*
import java.util.*
import javax.validation.constraints.NotBlank

@Controller("/clubs")
class ClubController(
        private val clubRepository: ClubRepository
) {

    @Get("/")
    fun findAll(): List<Club> {
        return clubRepository.findAll()
    }

    @Get("/{id}")
    fun findOne(id: Long): Optional<Club> {
        return clubRepository.findById(id)
    }

    @Post("/")
    fun create(@Body club: Club): Club {
        return clubRepository.save(club)
    }
}