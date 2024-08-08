package hu.bme.popit.ticketsystem.control.mapper;

import hu.bme.popit.ticketsystem.control.dto.MovieDTO;
import hu.bme.popit.ticketsystem.service.domain.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieDTOMapper {

    MovieDTO toMovieDTO(Movie movie);

    Movie toMovie(MovieDTO dto);

    List<MovieDTO> toMovieDTOList(List<Movie> movieList);

    List<Movie> toMovieList(List<MovieDTO> movieDTOList);

}
