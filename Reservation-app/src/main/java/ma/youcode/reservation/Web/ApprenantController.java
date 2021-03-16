package ma.youcode.reservation.Web;

import ma.youcode.reservation.DAO.ApprenantRepository;
import ma.youcode.reservation.Models.UsersEntity;
import ma.youcode.reservation.Services.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ApprenantController {
    @Autowired
    ApprenantRepository apprenantRepository;
    @Autowired
    ApprenantService apprenantService;

//    @RequestMapping("/users")
//    public String viewHomePage(Model model, @Param("keyword") String keyword) {
//        List<UsersEntity> listUsers = service.listAll(keyword);
//        model.addAttribute("listUsers", listUsers);
//        model.addAttribute("keyword", keyword);
//
//        return "users";
//    }
}
