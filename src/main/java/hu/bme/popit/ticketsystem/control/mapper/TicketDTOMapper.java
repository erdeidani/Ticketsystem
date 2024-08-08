package hu.bme.popit.ticketsystem.control.mapper;

import hu.bme.popit.ticketsystem.control.dto.TicketDTO;

import hu.bme.popit.ticketsystem.service.domain.Ticket;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketDTOMapper {

    TicketDTO toTicketDTO(Ticket ticket);

    Ticket toTicket(TicketDTO dto);

    List<TicketDTO> toTicketDTOList(List<Ticket> ticketList);

    List<Ticket> toTicketList(List<TicketDTO> ticketDTOList);

}
