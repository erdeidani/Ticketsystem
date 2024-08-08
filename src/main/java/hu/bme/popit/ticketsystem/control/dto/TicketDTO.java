package hu.bme.popit.ticketsystem.control.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class TicketDTO {

    private int id;

    private String movieName;

    private String owner;

}
