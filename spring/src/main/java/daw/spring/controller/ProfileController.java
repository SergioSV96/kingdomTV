package daw.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {

    @RequestMapping("/profile")
    public String index(Model model)
    {
        model.addAttribute("profileName", "Joe Doe");
        model.addAttribute("profileDescription");
        model.addAttribute("imgProfileBackground", "https://i.imgur.com/eWtfMME.png");
        return "profile";
    }
}
