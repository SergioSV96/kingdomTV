package daw.spring.controller;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import daw.spring.entities.TypeFilm;
import daw.spring.javaclass.ApiParser;

@Controller
public class WebController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value= {"/", "/index"})
    public String indexHTML(Model model) {
        log.info("Root path");
        //model.addAttribute("test", "testAttribute");
        return "index";
    }
    
    @RequestMapping("/registro")
    public String registroHTML(Model model){
    	//model.addAttribute("test", "testAttribute");
        return "registro";
    }
    
    @RequestMapping("/login")
    public String loginHTML(Model model){
    	//model.addAttribute("test", "testAttribute");
        return "login";
    }
    
    @RequestMapping("/contacto")
    public String contactoHTML(){
    	//model.addAttribute("test", "testAttribute");
        return "contacto";
    }
    
    @RequestMapping("/about")
    public String aboutHTML(){
    	//model.addAttribute("test", "testAttribute");
        return "about";
    }
    
    @RequestMapping("/series")
    public String seriesHTML(Model model){
    	//model.addAttribute("test", "testAttribute");
        return "series";
    }
    
    @RequestMapping("/infopeli")
    public String filmInfoHTML(){
    	//model.addAttribute("test", "testAttribute");
        return "infopeli";
    }
    
    @RequestMapping("/films")
    public String peliculasHTML(@RequestParam(value="name", required=false, defaultValue="World") String title, Model model) {
        try {
        	//Crear objeto ApiParser
            JSONObject jo = new ApiParser().readJsonFromUrl("https://api.themoviedb.org/3/movie/550?api_key=c16e8d049b0c5c16b9f10f731876549b");

            TypeFilm film = new TypeFilm(jo.getInt("id"), 1, jo.getString("original_title"), "Drama", jo.getString("release_date"), jo.getString("poster_path"));

            model.addAttribute("title", film.getTitle());
            model.addAttribute("img_source", "https://image.tmdb.org/t/p/w500" + film.getImg());
            model.addAttribute("datetime", film.getReleaseDate());
        }
        catch (IOException e)
        {

        }
        catch (JSONException f)
        {

        }

        return "peliculas";
    }
    
    /*public TypeFilm Get_Film() {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("C:\\Users\\m.torrijos\\Desktop\\movie_ids_04_28_2017.json"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);

            String name = (String) jsonObject.get("original_title");
            System.out.println(name);

            boolean age = (boolean) jsonObject.get("adult");
            System.out.println(age);

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
    */

    

}