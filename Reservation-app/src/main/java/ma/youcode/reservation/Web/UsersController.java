package ma.youcode.reservation.Web;

import ma.youcode.reservation.Repositories.ApprenantRepository;
import ma.youcode.reservation.Repositories.UsersRepository;
import ma.youcode.reservation.Models.ApprenantEntity;
import ma.youcode.reservation.Models.UsersEntity;
import ma.youcode.reservation.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ApprenantRepository apprenantRepository;

    @Autowired
    private UserService service;
    // ============ List Users and Search
    @RequestMapping("/users")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<UsersEntity> listUsers = service.listAll(keyword);
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("keyword", keyword);
        return "list-users";
    }

//    @GetMapping("/users")
//    public String listUsers(Model model) {
//        List<UsersEntity> listUsers = usersRepository.findAll();
//        model.addAttribute("listUsers", listUsers);
//        return "users";
//    }

//    ============= User registring

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new ApprenantEntity());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(@Valid ApprenantEntity user, BindingResult result) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        apprenantRepository.save(user);

        return "login";
    }

//=============================

//
//    @GetMapping("/edit/{id}")
//    public String showUpdateForm(@PathVariable("id") long id, Model model) {
//        ApprenantEntity apprenant = apprenantRepository.findById(id)
//        .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//        model.addAttribute("user", apprenant);
//
//        return "update-user";
//    }
//
//    @PostMapping("/update/{id}")
//    public String updateUser(@PathVariable("id") long id, ApprenantEntity apprenant, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            apprenant.setIduser(id);
//            return "update-user";
//        }
//
//        apprenantRepository.save(apprenant);
//
//        return "redirect:/users";
//    }





    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        UsersEntity user = usersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        usersRepository.delete(user);

        return "redirect:/users";

    }

//:::::::::::::::::::::::


    @GetMapping("/users")
    public String listApprenantActive(Model model, @Param("keyword") String keyword) {
        List<UsersEntity> listApprenant = usersRepository.getUsersEntityByStatusTrue();
      //  List<UsersEntity> listUsers = service.listAll(keyword);
        model.addAttribute("listApprenant", listApprenant);
       // model.addAttribute("listUsers", listUsers);
        return "list-users";
    }
    @GetMapping("/utilisateur-non-accepter")
    public String listApprenantDesactiver(Model model, @Param("keyword") String keyword) {
        List<UsersEntity> listApprenant = usersRepository.getUsersEntityByStatusFalse();
        List<UsersEntity> listUsers = service.listAll(keyword);
        model.addAttribute("listApprenantDes", listApprenant);
        model.addAttribute("listUsers", listUsers);
        return "utilisateur-non-accepter";
    }
    @RequestMapping("/edit-Apprenant-non-active/{id}")
    public String activerLeCompte(@PathVariable(name = "id") Long id) {
        if (id != null){
            service.activerLeCompte(id);
        }

        return "redirect:/utilisateur-non-accepter";
    }
    @RequestMapping("/edit-Apprenant/{id}")
    public String desactiverLeCompte(@PathVariable(name = "id") Long id) {
        if (id != null){
            service.desactiverLeCompte(id);
        }

        return "redirect:/users";
    }


}
