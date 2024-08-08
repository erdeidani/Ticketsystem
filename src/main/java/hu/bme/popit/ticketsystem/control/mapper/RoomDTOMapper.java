package hu.bme.popit.ticketsystem.control.mapper;

import hu.bme.popit.ticketsystem.control.dto.RoomDTO;
import hu.bme.popit.ticketsystem.service.domain.Room;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = PetDTOMapper.class)
public interface RoomDTOMapper {
    RoomDTO toRoomDTO(Room room);

    Room toRoom(RoomDTO dto);

    List<RoomDTO> toRoomDTOList(List<Room> roomList);

    List<Room> toRoomList(List<RoomDTO> roomDTOList);
}
