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

    @RequestMapping("/new-type")
    public String showNewTypeForm(Model model) {
        TypereservationEntity type = new TypereservationEntity();
        model.addAttribute("type", type);

        return "new_type";
    }


    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("update-type");

        TypereservationEntity type = service.get(id);
        mav.addObject("type", type);

        return mav;
    }

    @RequestMapping(value = "/save/type")
    public String saveType(@ModelAttribute("types") TypereservationEntity types) {

        service.save(types);

        return "redirect:/reservation-type";
    }

    @RequestMapping("/delete/{id}")
    public String deleteType(@PathVariable(name = "id") Long id) {
        service.delete(id);

        return "redirect:/reservation-type";
    }

}
