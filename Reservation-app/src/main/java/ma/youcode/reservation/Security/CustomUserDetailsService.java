package ma.youcode.reservation.Security;

import ma.youcode.reservation.Models.RoleEntity;
import ma.youcode.reservation.Models.UsersEntity;
import ma.youcode.reservation.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String cinOrEmail) throws UsernameNotFoundException {

        if (cinOrEmail.trim().isEmpty()) {
            throw new UsernameNotFoundException("username is empty");
        }

        UsersEntity user = userService.findByCinOrEmail(cinOrEmail);

        if (user == null) {
            throw new UsernameNotFoundException("User " + cinOrEmail + " not found");
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(UsersEntity user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        RoleEntity role = user.getRole();
        authorities.add(new SimpleGrantedAuthority(role.getRolenom()));
        return authorities;
    }
}
