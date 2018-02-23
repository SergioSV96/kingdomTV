package daw.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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