package hu.bme.popit.ticketsystem.data;

import hu.bme.popit.ticketsystem.data.entity.MovieEntity;
import hu.bme.popit.ticketsystem.service.domain.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = RoomEntityMapper.class)
public interface MovieEntityMapper {

    MovieEntity toMovieEntity(Movie movie);

    Movie toMovie(MovieEntity entity);

    List<MovieEntity> toMovieEntityList(List<Movie> movieList);

    List<Movie> toMovieList(List<MovieEntity> movieEntityList);
}
