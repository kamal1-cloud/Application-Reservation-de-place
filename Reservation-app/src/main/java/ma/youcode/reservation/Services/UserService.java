package ma.youcode.reservation.Services;

import ma.youcode.reservation.Repositories.UsersRepository;
import ma.youcode.reservation.Models.UsersEntity;
import ma.youcode.reservation.Security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UsersRepository userRepository;



    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        UsersEntity user = userRepository.getUserByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(user);
    }


    public List<UsersEntity> listAll(String keyword) {
        if (keyword != null) {
            return userRepository.search(keyword);
        }
        return userRepository.findAll();
    }
    public UsersEntity get(Long id) {
        return userRepository.findById(id).get();
    }

    public void activerLeCompte(Long id){
        userRepository.updateApprenantSetStatusToTrue(id);
    }
    public void desactiverLeCompte(Long id){
        userRepository.updateApprenantSetStatusToFalse(id);
    }


}
