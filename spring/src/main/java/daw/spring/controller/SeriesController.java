package daw.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SeriesController
{

    @RequestMapping("/series")
    public String peliculasHTML(){

        return "series";
    }

}
