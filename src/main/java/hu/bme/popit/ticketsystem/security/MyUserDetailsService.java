package hu.bme.popit.ticketsystem.security;

import hu.bme.popit.ticketsystem.data.AppUserEntityMapper;
import hu.bme.popit.ticketsystem.data.entity.AppUserEntity;
import hu.bme.popit.ticketsystem.data.entity.AppUserRole;
import hu.bme.popit.ticketsystem.data.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository repository;

    private AppUserEntityMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        AppUserEntity userEntity = repository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        AppUser myUser = mapper.toMyUser(userEntity);
        myUser.setPassword(userEntity.getPassword());
        return myUser;
    }

    public AppUser addUser(AppUser user) {
        AppUserEntity userEntity = mapper.toUserEntity(user);
        userEntity.setLocked(false);
        userEntity.setEnabled(true);
        userEntity.setName(user.getUsername());
        userEntity.setAppUserRole("ROLE_ADMIN");
        userEntity.setEmail("bodoginadb@gmail.com");

        System.out.println("entity to save: " + userEntity);

        AppUserEntity saved = repository.save(userEntity);
        System.out.println("entity saved: " + saved);
        AppUser myUser = mapper.toMyUser(saved);
        System.out.println("sent back: " + myUser);
        return myUser;
    }

    public List<AppUser> allUsers() {
        List<AppUserEntity> all = repository.findAll();
        return mapper.toMyUserList(all);
    }
}
