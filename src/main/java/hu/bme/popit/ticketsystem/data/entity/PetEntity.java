package hu.bme.popit.ticketsystem.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Pattern(regexp = "^[^;{}\"=]*$", message = "Room name contains invalid characters.")
    private String name;

    private Date birthDate;

    @Pattern(regexp = "^[^;{}\"=]*$", message = "Room name contains invalid characters.")
    private String motto;
}
