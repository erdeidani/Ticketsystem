package hu.bme.popit.ticketsystem.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
public class AppUserEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    private Long id;

    @Pattern(regexp = "^[^;{}\"=]*$", message = "Name contains invalid characters.")
    private String name;

    @NotBlank(message = "Username is mandatory")
    @Pattern(regexp = "^[^;{}\"=]*$", message = "Movie name contains invalid characters.")
    private String username;

    @NotBlank(message = "Email is mandatory")
    @Pattern(regexp = "^[^;{}\"=]*$", message = "Email contains invalid characters.")
    private String email;

    @NotBlank(message = "Password name is mandatory")
    @Pattern(regexp = "^[^;{}\"=]*$", message = "Password contains invalid characters.")
    private String password;

    private String appUserRole;

    private Boolean locked;
    private Boolean enabled;

}