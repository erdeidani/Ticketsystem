package hu.bme.popit.ticketsystem.control;

import hu.bme.popit.ticketsystem.control.mapper.PetDTOMapper;
import hu.bme.popit.ticketsystem.control.mapper.RoomDTOMapper;
import hu.bme.popit.ticketsystem.control.dto.RoomDTO;
import hu.bme.popit.ticketsystem.service.domain.Room;
import hu.bme.popit.ticketsystem.service.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {
    private final RoomDTOMapper mapper;

    private final RoomService service;

    Logger logger = LoggerFactory.getLogger(RoomController.class);

    @PostMapping("/room")
    public RoomDTO newRoom(@Valid @RequestBody RoomDTO roomDTO){
        logger.trace("Post request sent for new Room");
        logger.debug("RoomDTO object received: " + roomDTO);

        Room room = mapper.toRoom(roomDTO);

        logger.debug("Mapped DTO to room: " + room);
        Room savedRoom = service.newRoom(room);
        logger.debug("Room came back from service: " + savedRoom);
        return mapper.toRoomDTO(savedRoom);
    }

    @GetMapping("/room")
    public List<RoomDTO> allRooms(){
        logger.trace("Get All request for room");
        return mapper.toRoomDTOList(service.allRooms());
    }

    @DeleteMapping("/room/{id}")
    public RoomDTO deleteRoom(@PathVariable int id){
        logger.trace("Delete request for Room with id: " + id);

        Room deletedRoom = service.deleteRoom(id);
        logger.debug("Room came back from service: "+ deletedRoom);
        return mapper.toRoomDTO(deletedRoom);
    }

    @GetMapping("room/{id}")
    public RoomDTO getRoomById(@PathVariable int id){
        logger.trace("Get request for Room with id: "+id);

        Room room = service.findRoomById(id);
        logger.debug("Room came back from service: "+ room);
        return mapper.toRoomDTO(room);
    }

    @PutMapping("room/{id}")
    public RoomDTO updateTicket(@PathVariable int id,@Valid @RequestBody RoomDTO roomDTO){
        logger.trace("Put request for Room with id: "+id);

        Room room = mapper.toRoom(roomDTO);
        logger.debug("Mapped DTO to room: " + room);

        Room updatedRoom = service.putRoom(id, room);
        logger.debug("Updated Movie back from service: " + updatedRoom);
        return mapper.toRoomDTO(updatedRoom);
    }
}
