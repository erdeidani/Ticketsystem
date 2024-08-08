package hu.bme.popit.ticketsystem.data;

import hu.bme.popit.ticketsystem.data.entity.AppUserEntity;
import hu.bme.popit.ticketsystem.security.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppUserEntityMapper {

    @Mapping(source = "password", target = "password", qualifiedByName = "encoder")
    AppUserEntity toUserEntity(AppUser user);

    AppUser toMyUser(AppUserEntity entity);

    List<AppUserEntity> toUserEntityList(List<AppUser> userList);

    List<AppUser> toMyUserList(List<AppUserEntity> userEntityList);

    @Named("encoder")
    default String encodePassword(String password){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
