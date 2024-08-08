package hu.bme.popit.ticketsystem.data;

import hu.bme.popit.ticketsystem.data.entity.PetEntity;
import hu.bme.popit.ticketsystem.service.domain.Pet;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PetEntityMapper {
    PetEntity toPetEntity(Pet pet);

    Pet toPet(PetEntity entity);

    List<PetEntity> toPetEntityList(List<Pet> petList);

    List<Pet> toPetList(List<PetEntity> petEntityList);
}
