package daw.spring.controller;

import daw.spring.entities.Serie;
import daw.spring.javaclass.ApiParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SerieInfoController
{
	@RequestMapping("/seriesInfo/{id}")
    public String SeriesInfoHTML(Model model, @PathVariable int id)
    {

        Serie serie = new ApiParser().SearchOneSerieTMDB(Integer.toString(id));

        model.addAttribute("title", serie.getTitle());
        model.addAttribute("overview", serie.getSynopsis());
        model.addAttribute("releaseDate", serie.getReleaseDate());
        model.addAttribute("voteAverage", serie.getVoteAverage());
        model.addAttribute("poster", serie.getPoster());

        model.addAttribute("profileName", "USUARIO");


        return "seriesInfo";
    }

	
}
