package daw.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class SeriesController
{

    @RequestMapping("/series")
    public String seriesHTML(Model model){

        model.addAttribute("profileName","Prueba de KingomTV");


        return "series";
    }

}
