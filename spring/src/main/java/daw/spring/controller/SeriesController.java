package daw.spring.controller;

import daw.spring.entities.Serie;
import daw.spring.javaclass.ApiParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class SeriesController
{

    @RequestMapping("/series")
    public String seriesHTML(Model model){

        model.addAttribute("profileName","Prueba de KingomTV");

        List<Serie> sf = new ApiParser().SearchSeries("Designated");

        model.addAttribute("recommendedSeries", sf);

        return "series";
    }

}
