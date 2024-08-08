package hu.bme.popit.ticketsystem.data.repository;

import hu.bme.popit.ticketsystem.data.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {

    List<MovieEntity> findAllById(int id);

}
