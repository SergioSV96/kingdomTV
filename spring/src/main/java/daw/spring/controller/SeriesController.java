package daw.spring.controller;

import daw.spring.entities.Serie;
import daw.spring.javaclass.ApiParser;
import daw.spring.repositories.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class SeriesController
{

    @Autowired
    private SerieRepository repository;

    @PostConstruct
    public void init() {
        // repository.save(new TypeFilm(1, "Serie 1", "Drama", "05-02-2017", "https://image.tmdb.org/t/p/w500/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg"));
        // repository.save(new TypeFilm(2, "Serie 2", "Accion", "31-02-2050", "https://image.tmdb.org/t/p/w500/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg"));
    }

    @RequestMapping("/series")
    public String seriesHTML(Model model){

        model.addAttribute("profileName","Prueba de KingomTV");

        List<Serie> ss = new ApiParser().SearchSeries("Lost");

        model.addAttribute("recommendedSeries", ss);

        return "series";
    }

}
