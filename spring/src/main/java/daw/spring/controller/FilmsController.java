package daw.spring.controller;

import daw.spring.entities.TypeFilm;
import daw.spring.repository.FilmRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


@Controller
public class FilmsController {

    @Autowired
    private FilmRepository repository;

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = org.apache.commons.io.IOUtils.toString(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    @PostConstruct
    public void init() {
        repository.save(new TypeFilm(1, "Pelicula 1", "Drama", "05-02-2017", "https://image.tmdb.org/t/p/w500/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg"));
        repository.save(new TypeFilm(2, "Pelicula 2", "Accion", "31-02-2050", "https://image.tmdb.org/t/p/w500/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg"));
    }

    @RequestMapping("/movies")
    public String peliculasHTML(@RequestParam(value = "name", required = false, defaultValue = "World") String title, Model model) {
        try {
            JSONObject jo = readJsonFromUrl("https://api.themoviedb.org/3/movie/550?api_key=c16e8d049b0c5c16b9f10f731876549b");
            JSONObject jo2 = readJsonFromUrl("https://api.themoviedb.org/3/movie/100?api_key=c16e8d049b0c5c16b9f10f731876549b");
            TypeFilm film = new TypeFilm(jo.getInt("id"), 1, jo.getString("original_title"), "filter-genre2", jo.getString("release_date"), "https://image.tmdb.org/t/p/w500" + jo.getString("poster_path"));
            TypeFilm film2 = new TypeFilm(jo.getInt("id"), 2, jo2.getString("original_title"), "filter-genre3", jo2.getString("release_date"), "https://image.tmdb.org/t/p/w500" + jo2.getString("poster_path"));

            /*ModelAndView result = new ModelAndView();
            model.addAttribute("FilmTitle", film.Get_Title());
            model.addAttribute("FilmImg", "https://image.tmdb.org/t/p/w500" + film.Get_Img());
            model.addAttribute("FilmDate", film.Get_ReleaseDate());
*/

            JSONObject query = readJsonFromUrl("https://api.themoviedb.org/3/search/movie?api_key=c16e8d049b0c5c16b9f10f731876549b&query=Jack+Reacher");

            JSONArray jsonArray = query.getJSONArray("results");

            ArrayList<JSONObject> arrayList = new ArrayList(jsonArray.length());
            for (int i = 0; i < jsonArray.length(); i++) {
                arrayList.add(jsonArray.getJSONObject(i));
            }

            List<TypeFilm> list = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                list.add(new TypeFilm(arrayList.get(i).getInt("id"), arrayList.get(i).getString("title"), "filter-genre1", arrayList.get(i).getString("release_date"), "https://image.tmdb.org/t/p/w500" + arrayList.get(i).getString("poster_path")));
            }

            list.add(film);
            list.add(film2);
            model.addAttribute("recommendedFilms", list);
            model.addAttribute("profileName", "Joe Doe");
            //model.addAttribute("recommendedFilms", repository.findAll());

        } catch (IOException e) {

        } catch (JSONException f) {

        }

        return "movies";
    }

    public TypeFilm Get_Film() {
        /*JSONParser parser = new JSONParser();

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
        }*/

        return null;
    }

}
