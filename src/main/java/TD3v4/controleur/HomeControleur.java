package TD3v4.controleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControleur {

    @GetMapping("/")
    public String redirection() {
        return "redirect:/etudiants";
    }
}
