package hu.bme.popit.ticketsystem.control;

import hu.bme.popit.ticketsystem.control.dto.MovieDTO;
import hu.bme.popit.ticketsystem.control.mapper.MovieDTOMapper;
import hu.bme.popit.ticketsystem.service.MovieService;
import hu.bme.popit.ticketsystem.service.domain.Movie;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

    private final MovieDTOMapper mapper;

    private final MovieService service;

    Logger logger = LoggerFactory.getLogger(MovieController.class);

    @PostMapping("/movie")
    public MovieDTO newMovie(@Valid @RequestBody MovieDTO movieDTO) {
        logger.trace("Post request for new Movie");
        logger.debug("MovieDTO object received: " + movieDTO);

        Movie movie = mapper.toMovie(movieDTO);

        logger.debug("Mapped DTO to movie: " + movie);
        Movie savedMovie = service.newMovie(movie);
        logger.debug("Movie came back from service: " + savedMovie);
        return mapper.toMovieDTO(savedMovie);
    }

    @GetMapping("/movie")
    public List<MovieDTO> allMovies() {
        logger.trace("Get All request for movie");
        return mapper.toMovieDTOList(service.allMovies());
    }

    @DeleteMapping("/movie/{id}")
    public MovieDTO deleteMovie(@PathVariable int id) {
        logger.trace("Delete request for Movie with id: " + id);

        Movie deleteMovie = service.deleteMovie(id);
        logger.debug("Movie came back from service: " + deleteMovie);
        return mapper.toMovieDTO(deleteMovie);
    }

    @GetMapping("/movie/{id}")
    public MovieDTO getMovie(@PathVariable int id) {
        logger.trace("Get request for Movie with id: " + id);

        Movie getMovie = service.getMovie(id);
        logger.debug("Movie came back from service: " + getMovie);
        return mapper.toMovieDTO(getMovie);
    }

    @PutMapping("/movie/{id}")
    public MovieDTO putMovie(@PathVariable int id, @Valid @RequestBody MovieDTO movieDTO) {
        logger.trace("Put request for Movie with id: " + id);

        Movie movie = mapper.toMovie(movieDTO);
        logger.debug("Mapped DTO to movie: " + movie);

        Movie updatedMovie = service.updateMovie(id, movie);
        logger.debug("Updated Movie back from service: " + updatedMovie);

        return mapper.toMovieDTO(updatedMovie);
    }
}
