package daw.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FilmInfoController
{
	@RequestMapping("/moviesInfo")
    public String FilmInfoHTML(){

        return "moviesInfo";
    }

	
}
