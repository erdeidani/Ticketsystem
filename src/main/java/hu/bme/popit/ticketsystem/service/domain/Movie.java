package hu.bme.popit.ticketsystem.service.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Movie {

    private int id;

    private String movieName;

    private Room room;

}
