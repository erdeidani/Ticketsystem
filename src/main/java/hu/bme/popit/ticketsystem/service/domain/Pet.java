package hu.bme.popit.ticketsystem.service.domain;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Pet {

    private int id;

    private String name;

    private Date birthDate;

    private String motto;

}
