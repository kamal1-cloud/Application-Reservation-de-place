package ma.youcode.reservation.Web;

import ma.youcode.reservation.DAO.RoleRepository;
import ma.youcode.reservation.Models.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

//    @RequestMapping(value = ("/index") , method = RequestMethod.GET)
//    public String index(Model model){
//        List<RoleEntity> roles = roleRepository.findAll();
//        model.addAttribute("listRole", roles);
//        return "index";
//    }
}
