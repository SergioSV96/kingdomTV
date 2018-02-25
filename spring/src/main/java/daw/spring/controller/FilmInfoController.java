package daw.spring.controller;

import daw.spring.entities.Movie;
import daw.spring.javaclass.ApiParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FilmInfoController
{
    @RequestMapping("/moviesInfo/{id}")
    public String MoviesInfoHTML(Model model, @PathVariable int id)
    {

        Movie movie = new ApiParser().SearchOneFilmTMDB(Integer.toString(id));

        model.addAttribute("title", movie.getTitle());
        model.addAttribute("overview", movie.getSynopsis());
        model.addAttribute("releaseDate", movie.getReleaseDate());
        model.addAttribute("voteAverage", movie.getVoteAverage());
        model.addAttribute("poster", movie.getPoster());

        model.addAttribute("profileName", "USUARIO");


        return "moviesInfo";
    }

	
}
