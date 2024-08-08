package hu.bme.popit.ticketsystem.service;

import hu.bme.popit.ticketsystem.data.TicketEntityMapper;
import hu.bme.popit.ticketsystem.data.entity.TicketEntity;
import hu.bme.popit.ticketsystem.data.repository.TicketRepository;
import hu.bme.popit.ticketsystem.service.domain.Ticket;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TicketService {

    private final TicketRepository repository;

    private final TicketEntityMapper mapper;

    private final Logger logger = LoggerFactory.getLogger(TicketService.class);



    public List<TicketEntity> findAllById(int id){
        return repository.findAllById(id);
    }

    public Ticket newTicket(Ticket ticket){
        logger.trace("Post request for ticket");

        TicketEntity ticketEntity = mapper.toTicketEntity(ticket);
        logger.debug("Ticket to TicketEntity object received: "+ ticketEntity);

        TicketEntity savedEntity = repository.save(ticketEntity);
        logger.debug("TicketEntity is saved: " + savedEntity);
        return mapper.toTicket(savedEntity);
    }

    public List<Ticket> allTickets(){
        return mapper.toTicketList(repository.findAll());
    }


    public Ticket deleteTicket(int id){
        logger.trace("Delete request for ticket with id: "+id);

        Optional<TicketEntity> byId = repository.findById(id);
        logger.debug("Getting Ticket with id {}.", id);

        TicketEntity ticketEntityToRemove = null;
        if(byId.isPresent()){
            ticketEntityToRemove = byId.get();
        }

        if(ticketEntityToRemove != null){
            repository.delete(ticketEntityToRemove);
            logger.debug("TicketEntity is deleted: "+ ticketEntityToRemove);
            return mapper.toTicket(ticketEntityToRemove);
        }
        logger.error("Error deleting Ticket with id {}, no such ticket", id);
        throw new IllegalArgumentException("No Ticket with id = " + id + " found");
    }

    public Ticket findTicketById(int id) {
        logger.trace("Find Ticket by id");

        Optional<TicketEntity> ticketById = repository.findById(id);
        logger.debug("Getting Ticket with id {}.", id);

        TicketEntity ticketEntityToGetById = null;
        if(ticketById.isPresent()){
            ticketEntityToGetById = ticketById.get();
        }

        if(ticketEntityToGetById != null){
            return mapper.toTicket(ticketEntityToGetById);
        }

        logger.error( "Error getting Ticket with id {}, no such ticket", id);
        throw new IllegalArgumentException("No ticket with id: " + id + " found");
    }

    public Ticket putTicket(int id, Ticket ticket) {
        logger.debug("Ticket {} is about to be saved", ticket);

        ticket.setId(id);

        repository.save(mapper.toTicketEntity(ticket));

        return ticket;
    }
}
