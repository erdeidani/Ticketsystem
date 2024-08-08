package hu.bme.popit.ticketsystem.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.Cascade;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @NotBlank(message = "Room name is mandatory")
    @Pattern(regexp = "^[^;{}\"=]*$", message = "Room name contains invalid characters.")
    private String name;


    @JoinColumn(name = "pet_id")
    @OneToOne(cascade = CascadeType.REMOVE)
    private PetEntity pet;

}
