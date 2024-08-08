package hu.bme.popit.ticketsystem.control.mapper;

import hu.bme.popit.ticketsystem.control.dto.UserDTO;
import hu.bme.popit.ticketsystem.security.AppUser;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {

    UserDTO toUserDTO(AppUser user);

    AppUser toMyUser(UserDTO dto);

    List<UserDTO> toUserDTOList(List<AppUser> userList);

    List<AppUser> toMyUserList(List<UserDTO> userDTOList);

}
