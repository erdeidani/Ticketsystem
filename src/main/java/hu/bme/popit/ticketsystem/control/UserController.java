package hu.bme.popit.ticketsystem.control;

import hu.bme.popit.ticketsystem.control.dto.UserDTO;
import hu.bme.popit.ticketsystem.control.mapper.UserDTOMapper;
import hu.bme.popit.ticketsystem.security.AppUser;
import hu.bme.popit.ticketsystem.security.MyUserDetailsService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final MyUserDetailsService service;

    private final UserDTOMapper mapper;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(MyUserDetailsService service, UserDTOMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/admin/user")
    public UserDTO addUser(@Valid @RequestBody UserDTO userDTO) {
        logger.trace("Post request for new User");
        logger.debug("UserDTO object received: " + userDTO);

        AppUser myUser = mapper.toMyUser(userDTO);
        logger.debug("Mapped DTO to MyUser: " + myUser);


        AppUser addedUser = service.addUser(myUser);
        logger.debug("MyUser came back from service: " + addedUser);
        return mapper.toUserDTO(addedUser);
    }

    @GetMapping("/admin/user")
    public List<UserDTO> allUsers() {
        logger.trace("Get request for all Users");
        List<AppUser> appUsers = service.allUsers();
        return mapper.toUserDTOList(appUsers);
    }

}
