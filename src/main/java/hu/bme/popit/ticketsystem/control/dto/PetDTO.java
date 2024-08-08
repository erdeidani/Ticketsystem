package hu.bme.popit.ticketsystem.control.dto;

import lombok.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class PetDTO {

    private int id;

    private String name;

    private Date birthDate;

    private String motto;
}
