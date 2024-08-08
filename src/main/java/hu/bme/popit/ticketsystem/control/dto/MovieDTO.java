package hu.bme.popit.ticketsystem.control.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class MovieDTO {

    private int id;

    private String movieName;

    private RoomDTO room;
}
