package hu.bme.popit.ticketsystem.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @NotBlank(message = "Movie name is mandatory")
    @Pattern(regexp = "^[^;{}\"=]*$", message = "Movie name contains invalid characters.")
    private String movieName;

    @NotBlank(message = "Owner name is mandatory")
    @Pattern(regexp = "^[^;{}\"=]*$", message = "Owner name contains invalid characters.")
    private String owner;

}
