package ma.youcode.reservation.Services;

import ma.youcode.reservation.DAO.UsersRepository;
import ma.youcode.reservation.Models.RoleEntity;
import ma.youcode.reservation.Models.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UsersRepository userRepository;

    @Autowired
    public UserService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UsersEntity findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsersEntity user = userRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities((Collection<RoleEntity>) user.getRoleByIdrole()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<RoleEntity> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRolenom()))
                .collect(Collectors.toList());
    }
}
