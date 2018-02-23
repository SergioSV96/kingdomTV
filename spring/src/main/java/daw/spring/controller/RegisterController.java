package daw.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class RegisterController
{

    @RequestMapping("/register")
    public String registerHTML(Model model){

        model.addAttribute("profileName","Prueba de KingomTV");

        return "register";
    }

}
