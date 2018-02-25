package daw.spring.controller;

import daw.spring.entities.Movie;
import daw.spring.javaclass.ApiParser;
import daw.spring.repositories.MovieRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;


@Controller
public class FilmsController {

    @Autowired
    private MovieRepository repository;

    @PostConstruct
    public void init() {
       // repository.save(new TypeFilm(1, "Pelicula 1", "Drama", "05-02-2017", "https://image.tmdb.org/t/p/w500/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg"));
       // repository.save(new TypeFilm(2, "Pelicula 2", "Accion", "31-02-2050", "https://image.tmdb.org/t/p/w500/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg"));
    }

    @RequestMapping("/movies")
    public String peliculasHTML(Model model)
    {

        model.addAttribute("profileName","Prueba de KingomTV");

        List<Movie> sf = new ApiParser().SearchFilms("Teken");

        model.addAttribute("recommendedFilms", sf);

        return "movies";
    }
}
