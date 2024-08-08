package hu.bme.popit.ticketsystem.data;

import hu.bme.popit.ticketsystem.data.entity.TicketEntity;

import hu.bme.popit.ticketsystem.service.domain.Ticket;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketEntityMapper {

    TicketEntity toTicketEntity(Ticket ticket);

    Ticket toTicket(TicketEntity entity);

    List<TicketEntity> toTicketEntityList(List<Ticket> ticketList);

    List<Ticket> toTicketList(List<TicketEntity> ticketEntityList);


}
