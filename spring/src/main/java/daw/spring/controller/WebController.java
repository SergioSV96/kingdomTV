package daw.spring.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import daw.spring.Services.MoviesServices;
import daw.spring.entities.Movie;
import daw.spring.entities.Serie;
import daw.spring.entities.User;
import daw.spring.javaclass.ApiParser;
import daw.spring.repositories.MovieRepository;
import daw.spring.repositories.SerieRepository;
import daw.spring.repositories.UserRepository;
import daw.spring.security.UserComponent;

@Controller
public class WebController {
	
	@Autowired
	private UserComponent userComponent;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private SerieRepository serierepository;
	
	
/////////////////////
//INDEX CONTROLLER
/////////////////////
	
	
	@RequestMapping(value= {"/","/index"})
    public String index(Model model, Principal principal) {
        /*
        log.info("Root path");
        if (principal.getName() != null) {
        	model.addAttribute("profileName", principal.getName());
        }
        model.addAttribute("profileName","Iniciar sesión");
        return "index";
        */
		
		model.addAttribute("profileName", "Test");
		
		return "index";
    }
	

	
/////////////////////
//ERROR CONTROLLER TODO
/////////////////////

		/*
		@RequestMapping("/error")
		public String errorHTML(){
		return "error";
		}
		*/	
	
	
/////////////////////
//LOGIN CONTROLLER
/////////////////////
	
	
	@RequestMapping("/login")
    public String loginHTML(){
        return "login";
    }

	@RequestMapping("/loginerror")
    public String loginErrorHTML() {
        return "loginerror";
    }

	
/////////////////////
//REGISTER CONTROLLER
/////////////////////
	
	
    @RequestMapping("/register")
    public String registerHTML(Model model){

        model.addAttribute("profileName","Prueba de KingomTV");

        return "register";
    }
    
    @PostMapping("/register")
    public String registerUser(@RequestParam String name, @RequestParam String nick,
    						   @RequestParam String email, @RequestParam String pass){
       
    	userRepository.save(new User(name, nick, email, pass, "ROLE_USER"));
        return "login";
        
    }
    
    
/////////////////////
//PROFILE CONTROLLER
/////////////////////
    
    
    @RequestMapping("/profile")
    public String profileController (Model model) {
    	   	
    	if (!userComponent.isLoggedUser()) {
			return "login";
		}
    	
    	//TODO REVIEW THIS LINE WHEN LOG OUT IS FINISHED
    	userComponent.setLoggedUser(userRepository.findByNickname(userComponent.getLoggedUser().getNickname()));
			
    	model.addAttribute("name", userComponent.getLoggedUser().getName());
    	model.addAttribute("nickname", userComponent.getLoggedUser().getNickname());
    	
    	if (userComponent.getLoggedUser().isImageUploaded()) {
    		model.addAttribute("image", "/image/" + userComponent.getLoggedUser().getNickname()
    				+ userComponent.getLoggedUser().getId() + ".jpg");
    	} else {
    		model.addAttribute("image", "https://mdbootstrap.com/img/Photos/Avatars/img(31).jpg");
    	}
    	
        return "profile";
    }
    
    
    //UPLOAD PROFILE IMAGE
    
    private static final Path FILES_FOLDER = Paths.get(System.getProperty("user.dir"), "files");
    
    //Creates folder where images are going to be saved
    @PostConstruct
	public void init() throws IOException {

		if (!Files.exists(FILES_FOLDER)) {
			Files.createDirectories(FILES_FOLDER);
		}
	}
    
    //Upload image and save it to database and User session object
    //(POST)
    @PostMapping("/upload")
    public String imageUpload(Model model, @RequestParam("file") MultipartFile file) throws IOException{
	    
    	//Save user image to /uploads folder with username as file name
		String fileName = userComponent.getLoggedUser().getNickname()
				+ userComponent.getLoggedUser().getId() + ".jpg";

		if (!file.isEmpty()) {
			try {

				File uploadedFile = new File(FILES_FOLDER.toFile(), fileName);
				file.transferTo(uploadedFile);
				
				userComponent.getLoggedUser().setImageUploaded(true);
				userRepository.save(userComponent.getLoggedUser());
				
				return profileController(model);

			} catch (Exception e) {

				//model.addAttribute("fileName", fileName);
				//model.addAttribute("error", e.getClass().getName() + ":" + e.getMessage());

				return profileController(model);
			}
		} else {
			
			//model.addAttribute("error", "El archivo esta vacio");

			return profileController(model);
		}
    }
    
    
    //Handle image displaying in profile and for easy grabbing    
    @RequestMapping("/image/{fileName:.+}")
	public void handleFileDownload(@PathVariable String fileName, HttpServletResponse res)
			throws FileNotFoundException, IOException {

		Path image = FILES_FOLDER.resolve(fileName);

		if (Files.exists(image)) {
			res.setContentType("image/jpeg");
			res.setContentLength((int) image.toFile().length());
			FileCopyUtils.copy(Files.newInputStream(image), res.getOutputStream());

		} else {
			res.sendError(404, "File" + fileName + "(" + image.toAbsolutePath() + ") does not exist");
		}
	}
    	
    
    //CHANGING PASSWORD 
    //(POST)
    @PostMapping("/changePassword")
    public String changePassword(@RequestParam String password){
    	
    	userComponent.getLoggedUser().setPasswordHash(password);
    	userRepository.save(userComponent.getLoggedUser());
    	
    	//TODO INCLUDE LOG OUT HERE
    	
    	return "login";
        
    }
    
    //DELETE ACCOUNT
    //(POST)
    @PostMapping("/delete")
    public String delete(Model model) throws IOException{
    	    	  	
    	//TODO DELETE PROFILE IMAGE if (userComponent.getLoggedUser().isImageUploaded())
    	if (userComponent.getLoggedUser().isImageUploaded()) {
    		
    		 Files.delete(FILES_FOLDER.resolve(userComponent.getLoggedUser().getNickname()
    				 + userComponent.getLoggedUser().getId() + ".jpg"));
    		 
    	}
    	
    	userRepository.delete(userComponent.getLoggedUser());
    	
    	//TODO INCLUDE LOG OUT HERE
    	    	
    	return registerHTML(model);
        
    }
    
    //CHANGING NAME 
    //(POST)
    @PostMapping("/changeName")
    public String changeName(Model model, @RequestParam String newName){
    	
    	userComponent.getLoggedUser().setName(newName);;
    	userRepository.save(userComponent.getLoggedUser());
    	    	
    	return profileController(model);
        
    }
    
    //CHANGING NICKNAME 
    //(POST)
    @PostMapping("/changeNickname")
    public String changeNickname(Model model, @RequestParam String newNickname){
    	
    	userComponent.getLoggedUser().setNickname(newNickname);;
    	userRepository.save(userComponent.getLoggedUser());
    	    	
    	return profileController(model);
        
    }
    
    
/////////////////////
//ABOUT CONTROLLER
/////////////////////
    
    
    @RequestMapping("/about")
    public String aboutHTML(Model model){

        model.addAttribute("profileName","Prueba de KingomTV");

        return "about";
    }
    
    
/////////////////////
//CONTACT CONTROLLER
/////////////////////
    
    
    @RequestMapping("/contact")
    public String contactHTML(Model model){

        model.addAttribute("profileName","Prueba de KingomTV");

        return "contact";
    }
    
    
///////////////////////
//MOVIE INFO CONTROLLER
///////////////////////
    
    
    @RequestMapping("/moviesInfo/{id}")
    public String MoviesInfoHTML(Model model, @PathVariable int id)
    {

        Movie movie = new ApiParser().SearchOneFilmTMDB(Integer.toString(id));

        model.addAttribute("title", movie.getTitle());
        model.addAttribute("overview", movie.getSynopsis());
        model.addAttribute("releaseDate", movie.getReleaseDate());
        model.addAttribute("voteAverage", movie.getVoteAverage());
        model.addAttribute("poster", movie.getPoster());

        model.addAttribute("profileName", "USUARIO");


        return "moviesInfo";
    }
    
    
/////////////////////
//MOVIES CONTROLLER
/////////////////////
    
    
    /*
    @PostConstruct
    
    public void init() {
       // repository.save(new TypeFilm(1, "Pelicula 1", "Drama", "05-02-2017", "https://image.tmdb.org/t/p/w500/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg"));
       // repository.save(new TypeFilm(2, "Pelicula 2", "Accion", "31-02-2050", "https://image.tmdb.org/t/p/w500/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg"));
    }
	*/
	
    @RequestMapping("/movies")
    public String peliculasHTML(Model model)
    {

        model.addAttribute("profileName","Prueba de KingomTV");

        List<Movie> sf = new ApiParser().SearchFilms("Lost");

        model.addAttribute("recommendedFilms", sf);

        return "movies";
    }
    
    
/////////////////////////
//SERIES INFO CONTROLLER
/////////////////////////
    
    
    @RequestMapping("/seriesInfo/{id}")
    public String SeriesInfoHTML(Model model, @PathVariable int id)
    {

        Serie serie = new ApiParser().SearchOneSerieTMDB(Integer.toString(id));

        model.addAttribute("title", serie.getTitle());
        model.addAttribute("overview", serie.getSynopsis());
        model.addAttribute("releaseDate", serie.getReleaseDate());
        model.addAttribute("voteAverage", serie.getVoteAverage());
        model.addAttribute("poster", serie.getPoster());

        model.addAttribute("profileName", "USUARIO");


        return "seriesInfo";
    }
    
    
/////////////////////
//SERIES CONTROLLER
/////////////////////
    
    
    @PostConstruct
    public void initialize() {
        // repository.save(new TypeFilm(1, "Serie 1", "Drama", "05-02-2017", "https://image.tmdb.org/t/p/w500/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg"));
        // repository.save(new TypeFilm(2, "Serie 2", "Accion", "31-02-2050", "https://image.tmdb.org/t/p/w500/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg"));
    }

    @RequestMapping("/series")
    public String seriesHTML(Model model){

        model.addAttribute("profileName","Prueba de KingomTV");

        List<Serie> ss = new ApiParser().SearchSeries("Lost");

        model.addAttribute("recommendedSeries", ss);

        return "series";
    }
    
    
/////////////////////
//ADMIN CONTROLLER
/////////////////////
    
    
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
