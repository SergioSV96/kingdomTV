package daw.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class LoginController
{
	@RequestMapping("/login")
    public String loginHTML(){
        return "login";
    }

    
	@RequestMapping("/loginerror")
    public String loginErrorHTML() {
        return "loginerror";
    }
	
}
