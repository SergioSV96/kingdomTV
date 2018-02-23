package daw.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class RegisterController
{

    @RequestMapping("/registro")
    public String registroHTML(){

        return "registro";
    }

}
