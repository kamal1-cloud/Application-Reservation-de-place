package ma.youcode.reservation.Web;

import ma.youcode.reservation.DAO.ReservationRepository;
import ma.youcode.reservation.DAO.TypeReservationRepository;
import ma.youcode.reservation.DAO.UsersRepository;
import ma.youcode.reservation.Models.ApprenantEntity;
import ma.youcode.reservation.Models.ReservationEntity;
import ma.youcode.reservation.Models.TypereservationEntity;
import ma.youcode.reservation.Models.UsersEntity;
import ma.youcode.reservation.Security.MyUserDetails;
import ma.youcode.reservation.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class HistoriqueController {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    TypeReservationRepository typeReservationRepository;

    @Autowired
    UserService userService;

    @RequestMapping("/historique-Apprenant/{id}")
    public String historique(@PathVariable(name = "id") Long id, Model model, UsersEntity usersEntity) {

        if (id != null){

            UsersEntity userDetail = userService.get(id);
            List<ReservationEntity> listReservation = reservationRepository.getReservationEntityByIduser(id);
            model.addAttribute("userDetail", userDetail);
            model.addAttribute("listReservation", listReservation);
        }

        return "historique";
    }

    @RequestMapping("/historique")
    public String historiqueApprenant(Model model, @AuthenticationPrincipal MyUserDetails user) {

            MyUserDetails myUserDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Long userId= myUserDetails.getUser().getIduser(); //Fetch the custom property in User class

            List<ReservationEntity> listReservation = reservationRepository.getReservationEntityByIduser(userId);
            model.addAttribute("user", user);
            model.addAttribute("listReservation", listReservation);


        return "historique-apprenant";
    }
}
