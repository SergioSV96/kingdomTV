package daw.spring.controller;

import com.android.volley.toolbox.JsonObjectRequest;
import com.samskivert.mustache.Mustache;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import daw.spring.entities.*;

import java.io.*;
import java.util.Iterator;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import org.springframework.ui.Model;

import org.json.JSONException;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilmsController
{

    @RequestMapping("/films")
    public String peliculasHTML(@RequestParam(value="name", required=false, defaultValue="World") String title, Model model)
    {
        try {
            JSONObject jo = readJsonFromUrl("https://api.themoviedb.org/3/movie/550?api_key=c16e8d049b0c5c16b9f10f731876549b");

            TypeFilm film = new TypeFilm(jo.getInt("id"), 1, jo.getString("original_title"), "Drama", jo.getString("release_date"), jo.getString("poster_path"));

            model.addAttribute("title", film.Get_Title());
            model.addAttribute("img_source", "https://image.tmdb.org/t/p/w500" + film.Get_Img());
            model.addAttribute("datetime", film.Get_ReleaseDate());
        }
        catch (IOException e)
        {

        }
        catch (JSONException f)
        {

        }

        return "films";
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

}
