package hu.bme.popit.ticketsystem.control.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private int id;

    private String username;

    private String password;
}
