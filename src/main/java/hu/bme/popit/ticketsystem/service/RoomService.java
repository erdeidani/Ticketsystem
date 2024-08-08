package hu.bme.popit.ticketsystem.service;

import hu.bme.popit.ticketsystem.data.PetEntityMapper;
import hu.bme.popit.ticketsystem.data.RoomEntityMapper;
import hu.bme.popit.ticketsystem.data.entity.PetEntity;
import hu.bme.popit.ticketsystem.data.entity.RoomEntity;
import hu.bme.popit.ticketsystem.data.repository.PetRepository;
import hu.bme.popit.ticketsystem.data.repository.RoomRepository;
import hu.bme.popit.ticketsystem.service.domain.Room;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RoomService {

    private final RoomRepository repository;

    private final PetRepository petRepository;

    private final RoomEntityMapper mapper;

    private final PetEntityMapper petEntityMapper;

    private final Logger logger = LoggerFactory.getLogger(RoomService.class);

    public List<RoomEntity> findAllByid(int id) {
        return repository.findAllById(id);

    }

    public Room newRoom(Room room){
        logger.trace("Post request for room");

        RoomEntity roomEntity = mapper.toRoomEntity(room);
        logger.debug("Room to RoomEntity object received: "+roomEntity);

        PetEntity savedPet = petRepository.save(roomEntity.getPet());
        logger.debug("PetEntity is saved: "+ savedPet);

        roomEntity.setPet(savedPet);
        logger.debug("Updated the roomEntitys pet: "+ savedPet);

        RoomEntity savedRoom = repository.save(roomEntity);
        logger.debug("RoomEntity is saved: "+savedRoom);
        return mapper.toRoom(savedRoom);
    }

    public Room findRoomById(int id) {
        logger.trace("Find Room by id: "+ id);

        Optional<RoomEntity> roomById = repository.findById(id);
        logger.debug("Getting Room with id {}.", id);

        RoomEntity roomEntityToGetById = null;
        if(roomById.isPresent()){
            roomEntityToGetById = roomById.get();
        }

        if(roomEntityToGetById != null){
            return mapper.toRoom(roomEntityToGetById);
        }

        logger.error("Error getting Room with id {}, no such ticket", id);
        throw new IllegalArgumentException("No room with id: " + id + " found");
    }

    public List<Room> allRooms(){
        return mapper.toRoomList(repository.findAll());
    }

    public Room deleteRoom(int id) {
        logger.trace("Delete request for room with id: " + id);
        Optional<RoomEntity> roomById = repository.findById(id);

        RoomEntity roomEntityToRemove = null;
        if(roomById.isPresent()){
            roomEntityToRemove = roomById.get();
            repository.delete(roomEntityToRemove);
            logger.debug("Room has been deleted {}", roomEntityToRemove);
            return mapper.toRoom(roomEntityToRemove);
        }
        throw new IllegalArgumentException("no room with id " + id + " found");
    }

    public Room putRoom(int id, Room room) {
        logger.debug("Room {} is about to be saved", room);

        room.setId(id);
        repository.save(mapper.toRoomEntity(room));

        return room;
    }
}
