package ma.youcode.reservation.Web;

import ma.youcode.reservation.DAO.TypeReservationRepository;
import ma.youcode.reservation.DAO.UsersRepository;
import ma.youcode.reservation.Models.TypereservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TypeReservationController {
    @Autowired
    TypeReservationRepository typeReservationRepository;

    @GetMapping("/Type/reservation")
    public String listUsers(Model model) {
        List<TypereservationEntity> listTypes = typeReservationRepository.findAll();
        model.addAttribute("listTypes", listTypes);
        return "reservation-type";
    }

}
