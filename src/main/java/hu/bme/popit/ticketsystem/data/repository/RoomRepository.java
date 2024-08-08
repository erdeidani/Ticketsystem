package hu.bme.popit.ticketsystem.data.repository;

import hu.bme.popit.ticketsystem.data.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
    List<RoomEntity> findAllById(int id);
}
