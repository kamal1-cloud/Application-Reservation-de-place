package ma.youcode.reservation.Web;

import ma.youcode.reservation.DAO.ApprenantRepository;
import ma.youcode.reservation.DAO.UsersRepository;
import ma.youcode.reservation.Models.ApprenantEntity;
import ma.youcode.reservation.Models.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Access;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ApprenantRepository apprenantRepository;

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<UsersEntity> listUsers = usersRepository.findAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new ApprenantEntity());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(ApprenantEntity user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        apprenantRepository.save(user);

        return "register_success";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        UsersEntity user = usersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        usersRepository.delete(user);
        return "redirect:/index";
    }
//    @GetMapping("/users")
//    public ResponseEntity<UsersEntity> getUser(){
//
//        UsersEntity user = (UsersEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        return  new ResponseEntity<UsersEntity>(user, HttpStatus.OK);
//    }
}
