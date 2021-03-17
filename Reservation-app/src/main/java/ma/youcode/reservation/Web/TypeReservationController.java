package ma.youcode.reservation.Web;

import ma.youcode.reservation.DAO.TypeReservationRepository;
import ma.youcode.reservation.DAO.UsersRepository;
import ma.youcode.reservation.Models.ApprenantEntity;
import ma.youcode.reservation.Models.TypereservationEntity;
import ma.youcode.reservation.Services.TypeReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TypeReservationController {
    @Autowired
    TypeReservationRepository typeReservationRepository;
    @Autowired
    private TypeReservationService service;

    @GetMapping("/Type/reservation")
    public String listType(Model model) {
        List<TypereservationEntity> listTypes = typeReservationRepository.findAll();
        model.addAttribute("listTypes", listTypes);
        return "reservation-type";
    }
//=======================

    @GetMapping("/formType")
    public String showNewTypeForm(Model model) {
        // create model attribute to bind form data
        model.addAttribute("type", new TypereservationEntity());
        return "newType";
    }
    @PostMapping( "/ajouterType")
    public String saveType(@ModelAttribute("type") TypereservationEntity type) {
        // save type to database
        service.saveType(type);
        return "redirect:/reservation-type";
    }
//    =====================

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditTypeForm(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("update-type");

        TypereservationEntity type = service.get(id);
        mav.addObject("type", type);

        return mav;
    }


    @RequestMapping("/deleteType/{id}")
    public String deleteType(@PathVariable("id") Integer id) {
        service.deleteType(id);
        return "redirect:/Type/reservation";
    }

}
