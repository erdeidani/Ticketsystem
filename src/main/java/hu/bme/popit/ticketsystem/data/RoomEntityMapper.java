package hu.bme.popit.ticketsystem.data;

import hu.bme.popit.ticketsystem.data.entity.RoomEntity;
import hu.bme.popit.ticketsystem.service.domain.Room;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = PetEntityMapper.class)
public interface RoomEntityMapper {
    RoomEntity toRoomEntity(Room room);

    Room toRoom(RoomEntity entity);

    List<RoomEntity> toRoomEntityList(List<Room> roomList);

    List<Room> toRoomList(List<RoomEntity> roomEntityList);
}
