package hu.bme.popit.ticketsystem.data.repository;

import hu.bme.popit.ticketsystem.data.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<PetEntity, Integer> {
    List<PetEntity> findAllById(int id);
}
