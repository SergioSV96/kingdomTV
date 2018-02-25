package daw.spring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import daw.spring.entities.User;
import daw.spring.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class RegisterController
{

	private final UserRepository userRepository;
	
	@Autowired
	public RegisterController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
    @RequestMapping("/register")
    public String registerHTML(Model model){

        model.addAttribute("profileName","Prueba de KingomTV");

        return "register";
    }
    
    @PostMapping("/register")
    public String registerUser(@RequestParam String name, @RequestParam String nick,
    						   @RequestParam String email, @RequestParam String pass){
       
    	userRepository.save(new User(name, nick, email, pass, "", "ROLE_USER"));
    	
        return "login";
        
    }

}
