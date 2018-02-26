package daw.spring.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String index(Model model, Principal principal) {
        log.info("Root path");
        if (principal.getName() != null) {
        	model.addAttribute("profileName", principal.getName());
        }
        model.addAttribute("profileName","Iniciar sesión");
        return "index";
    }

    @RequestMapping("/index")
    public void index2(Model model, Principal principal) {
        log.info("Routing to root path");
        index(model, principal);
    }

}
