package ma.youcode.reservation.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({"","/","/index"})
    public String viewHomePage() {
        return "index";
    }
    
}
