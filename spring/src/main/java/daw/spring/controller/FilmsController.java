package daw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FilmsController
{

    @RequestMapping("/peliculas")
    public String peliculasHTML(){

        return "peliculas";
    }

}
