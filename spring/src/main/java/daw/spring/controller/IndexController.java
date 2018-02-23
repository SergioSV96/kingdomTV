package daw.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String index(Model model) {
        log.info("Root path");
        model.addAttribute("test", "testAttribute");
        return "index";
    }

    @RequestMapping("/index")
    public void index2(Model model) {
        log.info("Routing to root path");
        index(model);
    }

}
