package daw.spring.controller;

import daw.spring.Services.MoviesServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController
{
    @RequestMapping("/adminMain")
    public String adminHTML(Model model){
        model.addAttribute("profileName", "Administrador");
        model.addAttribute("mailUser", "admin@kingdom.tv");
        return "adminMain";
    }

    @RequestMapping("/moviesPage")
    public String moviesPageHTML(Model model){

        MoviesServices ms = new MoviesServices();

        model.addAttribute("movies", ms.getAllPFilms());

        model.addAttribute("profileName", "Administrador");
        model.addAttribute("mailUser", "admin@kingdom.tv");

        return "moviesPage";
    }

    @RequestMapping("/showsPage")
    public String showsPageHTML(Model model){
        model.addAttribute("profileName", "Administrador");
        model.addAttribute("mailUser", "admin@kingdom.tv");
        return "showsPage";
    }

    /////////////////////
    //USERS ADMIN METHODS
    /////////////////////

    @RequestMapping("/usersPage")
    public String usersPageHTML(Model model)
    {
        model.addAttribute("profileName", "Administrador");
        model.addAttribute("mailUser", "admin@kingdom.tv");
        return "usersPage";
    }

    /////////////////////////
    //END USERS ADMIN METHODS
    /////////////////////////
}
