package hu.bme.popit.ticketsystem.control.mapper;

import hu.bme.popit.ticketsystem.control.dto.PetDTO;
import hu.bme.popit.ticketsystem.service.domain.Pet;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PetDTOMapper {
    PetDTO toPetDTO(Pet pet);

    Pet toPet(PetDTO dto);

    List<PetDTO> toPetDTOList(List<Pet> petList);

    List<Pet> toPetList(List<PetDTO> petDTOList);
}
