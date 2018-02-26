package daw.spring.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {

	//public static UserRepository userRepository;
	
    @RequestMapping("/profile")
    public String profileController (Model model, Principal principal) {
    	
    	model.addAttribute("usuario", principal.getName());
    	//((User) model.addAttribute("image", principal.getName())).getImage();
    	
        return "profile";
    }
    
    /*@RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String imageUpload(@RequestParam("file") MultipartFile file, Principal principal) throws IOException{
	    
		userRepository.findByNickname(principal.getName()).setImage(file);
    	
        return "profile";
    	/*if (!file.isEmpty()) {
	     BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
	     File destination = new File("/profileImages"); // something like C:/Users/tom/Documents/nameBasedOnSomeId.png
	     ImageIO.write(src, "png", destination);
	     //Save the id you have used to create the file name in the DB. You can retrieve the image in future with the ID.
	     }*/


}
