package daw.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SerieInfoController
{
	@RequestMapping("/seriesInfo")
    public String FilmInfoHTML(){

        return "seriesInfo";
    }

	
}
