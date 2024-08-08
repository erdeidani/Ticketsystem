package hu.bme.popit.ticketsystem.data.repository;

import hu.bme.popit.ticketsystem.data.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {

    List<TicketEntity> findAllById(int id);

}
