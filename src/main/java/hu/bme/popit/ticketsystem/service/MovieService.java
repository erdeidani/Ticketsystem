package hu.bme.popit.ticketsystem.service;

import hu.bme.popit.ticketsystem.data.entity.MovieEntity;
import hu.bme.popit.ticketsystem.service.domain.Movie;
import hu.bme.popit.ticketsystem.data.MovieEntityMapper;
import hu.bme.popit.ticketsystem.data.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository repository;

    private final MovieEntityMapper mapper;

    Logger logger = LoggerFactory.getLogger(MovieService.class);

    public List<MovieEntity> findAllById(int id){
        return repository.findAllById(id);
    }

    public Movie newMovie(Movie movie){
        logger.trace("Post request for movie");

        MovieEntity movieEntity = mapper.toMovieEntity(movie);
        logger.debug("Movie to MovieEntity object received: "+ movieEntity);

        MovieEntity savedEntity = repository.save(movieEntity);
        logger.debug("MovieEntity is saved: "+ movieEntity);
        return mapper.toMovie(savedEntity);
    }

    public Movie deleteMovie(int id){
        logger.trace("Delete request for movie with id: "+id);

        Optional<MovieEntity> byid= repository.findById(id);
        logger.debug("Optional Movie from id to MovieEntity object recieved: "+ byid);

        MovieEntity movieEntity = null;
        if(byid.isPresent()){
            movieEntity=byid.get();
            if(movieEntity!=null){
                repository.delete(movieEntity);
                logger.debug("MovieEntity is deleted: "+ movieEntity);
                return mapper.toMovie(movieEntity);
            }
        }
        throw new IllegalArgumentException("No movie with id: " + id + " found");
    }

    public List<Movie> allMovies(){
        return mapper.toMovieList(repository.findAll());
    }

    public Movie getMovie(int id){
        logger.trace("Get request for movie with id: "+ id);

        Optional<MovieEntity> byid= repository.findById(id);
        logger.debug("Optional Movie from id to MovieEntity object recieved: "+ byid);

        MovieEntity movieEntity = null;
        if(byid.isPresent()){
            movieEntity=byid.get();

            if(movieEntity!=null){
                return mapper.toMovie(movieEntity);
            }
        }
        throw new IllegalArgumentException("The movie id '"+ id+"' doesn't exist");
    }

    public Movie updateMovie(int id, Movie movie) {
        logger.trace("Put request for movie with id: "+id);


        movie.setId(id);
        repository.save(mapper.toMovieEntity(movie));

        return movie;
    }
}
