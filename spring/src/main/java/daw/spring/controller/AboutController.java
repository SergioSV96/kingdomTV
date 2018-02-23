package daw.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class AboutController
{

    @RequestMapping("/about")
    public String aboutHTML(Model model){

        model.addAttribute("profileName","Prueba de KingomTV");

        return "about";
    }

}
