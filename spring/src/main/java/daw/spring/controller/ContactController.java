package daw.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class ContactController{

    @RequestMapping("/contact")
    public String contactHTML(Model model){

        model.addAttribute("profileName","Prueba de KingomTV");

        return "contact";
    }

}