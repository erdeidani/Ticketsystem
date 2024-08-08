package hu.bme.popit.ticketsystem.control;

import hu.bme.popit.ticketsystem.control.dto.TicketDTO;
import hu.bme.popit.ticketsystem.control.mapper.TicketDTOMapper;

import hu.bme.popit.ticketsystem.service.domain.Ticket;
import hu.bme.popit.ticketsystem.service.TicketService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api")
public class TicketController {

    private final TicketDTOMapper mapper;

    private final TicketService service;

    Logger logger = LoggerFactory.getLogger(TicketController.class);

    @PostMapping("/ticket")//add
    public TicketDTO newTicket(@Valid @RequestBody TicketDTO ticketDTO ){
        logger.trace("Post request for new Ticket");
        logger.debug("TicketDTO object received: {}", ticketDTO);

        Ticket ticket = mapper.toTicket(ticketDTO);

        logger.debug("Mapped DTO to ticket: {}", ticket);
        Ticket savedTicket = service.newTicket(ticket);
        logger.debug("Ticket came back from service: {}",  savedTicket);
        return mapper.toTicketDTO(savedTicket);
    }

    @GetMapping("/ticket")//getAll
    public List<TicketDTO> allTickets(){
        logger.trace("Get All request for ticket");
        return mapper.toTicketDTOList(service.allTickets());
    }

    @DeleteMapping("/ticket/{id}")
    public TicketDTO deleteTicket(@PathVariable int id){//delete
        logger.trace("Delete request for Ticket with id: " + id);

        Ticket deletedTicket = service.deleteTicket(id);
        logger.debug("Ticket came back from service: "+ deletedTicket);
        return mapper.toTicketDTO(deletedTicket);
    }

    @GetMapping("/ticket/{id}")
    public TicketDTO getTicket(@PathVariable int id){//getOne
        logger.trace("Get request for Ticket with id: "+id);

        Ticket ticket = service.findTicketById(id);

        logger.debug("Ticket came back from service: {}", ticket);
        return mapper.toTicketDTO(ticket);
    }

    @PutMapping("/ticket/{id}")
    public TicketDTO updateTicket(@PathVariable int id, @Valid @RequestBody TicketDTO ticketDTO){
        logger.trace("Put request for Ticket with id: "+ id);

        Ticket ticket = mapper.toTicket(ticketDTO);
        logger.debug("Mapped DTO to ticket: " + ticket);

        Ticket updatedTicket = service.putTicket(id, ticket);
        logger.debug("Updated Movie back from service: " + updatedTicket);
        return mapper.toTicketDTO(updatedTicket);
    }
}
