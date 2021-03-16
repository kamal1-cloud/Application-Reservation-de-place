package ma.youcode.reservation.Web;

import ma.youcode.reservation.DAO.ReservationRepository;
import ma.youcode.reservation.DAO.RoleRepository;
import ma.youcode.reservation.Models.ReservationEntity;
import ma.youcode.reservation.Models.TypereservationEntity;
import ma.youcode.reservation.Services.ReservationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ReservationServices reservationServices;

//    @GetMapping("/reservation")
//    public String listType(Model model) {
//        List<ReservationEntity> listReservation = reservationRepository.findAll();
//        model.addAttribute("listReservation", listReservation);
//        return "reservation";
//    }

    @GetMapping("/reservation")
    public String listReservation(Model model) {
        List<ReservationEntity> listReservation = reservationRepository.getReservationEntityByStatus();
        model.addAttribute("listReservation", listReservation);
        return "reservation";
    }
    @RequestMapping("/new-reservation")
    public String showNewTypeForm(Model model) {
        ReservationEntity type = new ReservationEntity();
        model.addAttribute("type", type);

        return "new_reservation";
    }


    @RequestMapping(value = "/save-reservation")
    public String saveReservation(@ModelAttribute("reservation") ReservationEntity reservation) {

        reservationServices.save(reservation);

        return "redirect:/reservation";
    }

    @RequestMapping("/edit-reservation/{id}")
    public String editStatus(@PathVariable(name = "id") Long id) {
        if (id != null){
            reservationServices.updateStatus(id);
        }

        return "redirect:/reservation";
    }


    @RequestMapping("/delete-reservation/{id}")
    public String deleteReservation(@PathVariable(name = "id") Long id) {
        reservationServices.delete(id);

        return "redirect:/reservation";
    }
}
