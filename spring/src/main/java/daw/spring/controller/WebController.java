package daw.spring.controller;

import java.security.Principal;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import daw.spring.Services.MoviesServices;
import daw.spring.entities.Movie;
import daw.spring.entities.Serie;
import daw.spring.entities.User;
import daw.spring.javaclass.ApiParser;
import daw.spring.repositories.MovieRepository;
import daw.spring.repositories.SerieRepository;
import daw.spring.repositories.UserRepository;

@Controller
public class WebController {
	
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
        /*log.info("Root path");
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
       
    	userRepository.save(new User(name, nick, email, pass, "", "ROLE_USER"));
    	
        return "login";
        
    }
    
    
/////////////////////
//PROFILE CONTROLLER
/////////////////////
    
    
    @RequestMapping("/profile")
    public String profileController (Model model) {
    	
    	model.addAttribute("usuario", "Hola que tal");
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
    
    
    @PostConstruct
    public void init() {
       // repository.save(new TypeFilm(1, "Pelicula 1", "Drama", "05-02-2017", "https://image.tmdb.org/t/p/w500/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg"));
       // repository.save(new TypeFilm(2, "Pelicula 2", "Accion", "31-02-2050", "https://image.tmdb.org/t/p/w500/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg"));
    }

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
