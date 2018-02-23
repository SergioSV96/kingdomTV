package daw.spring.controller;

import daw.spring.entities.User;
import daw.spring.security.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProfileController
{


    @Autowired
    private UserSecurity userSecurity;

    @RequestMapping("/add_new_user")
    public String add_new_user(Model model, User user){
        //repository.save(user);
        return "index";
    }


    @Autowired
    private UserSecurity repository;

    @PostConstruct
    public void init()
    {

        List<String> roles = new ArrayList<String>();
        roles.add("ADMIN");
        roles.add("USER");

    }

    @RequestMapping("/profile")
    public String ProfileController (Model model)
    {
        model.addAttribute("profileName","Prueba de KingomTV");

        return "profile";
    }


}
