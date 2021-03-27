package ma.youcode.reservation.Web;

import ma.youcode.reservation.DAO.ApprenantRepository;
import ma.youcode.reservation.Models.ApprenantEntity;
import ma.youcode.reservation.Models.UsersEntity;
import ma.youcode.reservation.Services.ApprenantService;
import ma.youcode.reservation.Services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ApprenantController {
    @Autowired
    ApprenantRepository apprenantRepository;
    @Autowired
    ApprenantService apprenantService;
    @Autowired
    private UserService service;

    @GetMapping("/users")
    public String listApprenantActive(Model model, @Param("keyword") String keyword) {
        List<ApprenantEntity> listApprenant = apprenantRepository.getUsersEntityByStatusTrue();
        List<UsersEntity> listUsers = service.listAll(keyword);
        model.addAttribute("listApprenant", listApprenant);
        model.addAttribute("listUsers", listUsers);
        return "list-users";
    }
    @GetMapping("/utilisateur-non-accepter")
    public String listApprenantDesactiver(Model model, @Param("keyword") String keyword) {
        List<ApprenantEntity> listApprenant = apprenantRepository.getUsersEntityByStatusFalse();
        List<UsersEntity> listUsers = service.listAll(keyword);
        model.addAttribute("listApprenantDes", listApprenant);
        model.addAttribute("listUsers", listUsers);
        return "utilisateur-non-accepter";
    }
    @RequestMapping("/edit-Apprenant-non-active/{id}")
    public String activerLeCompte(@PathVariable(name = "id") Long id) {
        if (id != null){
            apprenantService.activerLeCompte(id);
        }

        return "redirect:/utilisateur-non-accepter";
    }
    @RequestMapping("/edit-Apprenant/{id}")
    public String desactiverLeCompte(@PathVariable(name = "id") Long id) {
        if (id != null){
            apprenantService.desactiverLeCompte(id);
        }

        return "redirect:/users";
    }

//    @RequestMapping("/users")
//    public String viewHomePage(Model model, @Param("keyword") String keyword) {
//        List<UsersEntity> listUsers = service.listAll(keyword);
//        model.addAttribute("listUsers", listUsers);
//        model.addAttribute("keyword", keyword);
//
//        return "users";
//    }
}
