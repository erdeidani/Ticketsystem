package hu.bme.popit.ticketsystem.control.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class RoomDTO {

    private int id;

    private String name;

    private PetDTO pet;
}
