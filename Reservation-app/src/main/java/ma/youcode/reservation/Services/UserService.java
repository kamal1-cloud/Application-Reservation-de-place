package ma.youcode.reservation.Services;

import ma.youcode.reservation.DAO.RoleRepository;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


//
//    public UsersEntity findUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
    public List<UsersEntity> listAll(String keyword) {
        if (keyword != null) {
            return userRepository.search(keyword);
        }
        return userRepository.findAll();
    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        UsersEntity user = userRepository.findByEmail(email);
//        if(user != null) {
//            List<GrantedAuthority> authorities = getUserAuthority(user.getIdrole());
//            return buildUserForAuthentication(user, authorities);
//        } else {
//            throw new UsernameNotFoundException("username not found");
//        }
//    }
//
//    private List<GrantedAuthority> getUserAuthority(Long idrole) {
//        RoleEntity role = roleRepository.findByRolenom(String.valueOf(roleRepository.findById(idrole)));
//        return (List<GrantedAuthority>) role;
//    }
//
//    private List<GrantedAuthority> getUserAuthority(Set<RoleEntity> userRoles) {
//        Set<GrantedAuthority> roles = new HashSet<>();
//        userRoles.forEach((role) -> {
//            roles.add(new SimpleGrantedAuthority(role.getRolenom()));
//        });
//
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
//        return grantedAuthorities;
//    }
//
//    private UserDetails buildUserForAuthentication(UsersEntity user, List<GrantedAuthority> authorities) {
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
//    }

//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<RoleEntity> roles){
//        return roles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getRolenom()))
//                .collect(Collectors.toList());
//    }



    @Transactional(readOnly = true)
    public UsersEntity findByCinOrEmail(String cinOrEmail) {
        UsersEntity user = null;
        try {
            user = userRepository.findByCinOrEmail(cinOrEmail);
        } catch (Exception e) {
            throw e;
        }
        return user;
    }
}
