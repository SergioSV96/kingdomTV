package daw.spring.controller;

import daw.spring.entities.TypeUser;
import daw.spring.repository.UserRepository;
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
    public String add_new_user(Model model, TypeUser user){
        repository.save(user);
        return "index";
    }


    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void init()
    {

        List<String> roles = new ArrayList<>();
        roles.add("ADMIN");
        roles.add("USER");

        TypeUser u1 = new TypeUser("LTNs35", "migueltg352340@gmail.com", "password", true, roles);
        repository.save(u1);

    }
    @RequestMapping("/profile")
    public String serveUserProfile(Model model, @RequestParam Optional<String> emailUser, @RequestParam Optional<String> passUser, @RequestParam Optional<Boolean> sent) {
        if(sent.isPresent()) {
            emailUser.ifPresent(s -> userSecurity.getLoggedUser().setEmail(s));
            if(!passUser.get().equals("")) {
                userSecurity.getLoggedUser().setPasswordHash(passUser.get());
            }
            repository.save(userSecurity.getLoggedUser());
        }
        return "profile";
    }

}
