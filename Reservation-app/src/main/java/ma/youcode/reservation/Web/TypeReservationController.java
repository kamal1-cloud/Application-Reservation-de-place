package ma.youcode.reservation.Web;

import ma.youcode.reservation.Repositories.TypeReservationRepository;
import ma.youcode.reservation.Models.TypereservationEntity;
import ma.youcode.reservation.Services.TypeReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "add-type";
    }

    @PostMapping( "/ajouterType")
    public String saveType(@ModelAttribute("type") TypereservationEntity type) {
        // save type to database
        service.saveType(type);
        return "redirect:/Type/reservation";
    }
//    =====================

    @RequestMapping("/updateType/{id}")
    public String showEditTypeForm(@PathVariable(name = "id") Integer id , Model model) {
        // get type from the service
        TypereservationEntity type = service.get(id);
        // set type as a model attribute to pre-populate the form
        model.addAttribute("type", type);

        return "update-type";
    }


    @RequestMapping("/deleteType/{id}")
    public String deleteType(@PathVariable("id") Integer id) {
        service.deleteType(id);
        return "redirect:/Type/reservation";
    }
//    ============= Filter by type
//@GetMapping("/redeem_accounts_list_by_redeemer/{id}")
//public ModelAndView redeemAccByRedeemer(@PathVariable(value = "id") Long id , Model model)
//{
//    ModelAndView modelAndView = new ModelAndView();
//    List<RedeemAccountDTO> listOfRedeemAccByRedeemer = new ArrayList<RedeemAccountDTO>();
//    try
//    {
//        listOfRedeemAccByRedeemer = redeemAccountService.findRedeemAccByEmployee(id);
//        modelAndView.addObject("listOfRedeemAccByRedeemer", listOfRedeemAccByRedeemer);
//        modelAndView.addObject("totalItems", listOfRedeemAccByRedeemer.size());
//        List<EmployeeDTO> redeemerList = redeemAccountService.getRedeemers("Redeemer", "Manager");
//        model.addAttribute("employees",redeemerList);
//        modelAndView.setViewName("redirect:/redeem_accounts_list");
//    }
//    catch(Exception e)
//    {
//        log.error("Error in retrieving the list", e);
//        e.printStackTrace();
//    }
//
//    return modelAndView;
//}
}