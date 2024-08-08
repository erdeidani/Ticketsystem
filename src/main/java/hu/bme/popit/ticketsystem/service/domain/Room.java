package hu.bme.popit.ticketsystem.service.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Room {
    private int id;

    private String name;

    private Pet pet;
}
