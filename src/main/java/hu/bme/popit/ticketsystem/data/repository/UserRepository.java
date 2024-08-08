package hu.bme.popit.ticketsystem.data.repository;

import hu.bme.popit.ticketsystem.data.entity.AppUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUserEntity, Long> {

    AppUserEntity findByUsername(String username);
}
