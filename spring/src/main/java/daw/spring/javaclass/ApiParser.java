package daw.spring.javaclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import daw.spring.entities.Genre;
import daw.spring.entities.Movie;
import daw.spring.entities.Serie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiParser
{
	private JSONObject ReadJsonFromUrl(String url) throws IOException, JSONException
    {
        InputStream is = new URL(url).openStream();
        try
        {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = org.apache.commons.io.IOUtils.toString(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        }
        finally
        {
            is.close();
        }
    }

    //Search the Movie with the API. Needs the id known.
    public Movie SearchOneFilmTMDB(String id)
    {
        try
        {
            List<Genre> gr = new ArrayList<Genre>();
            gr.add(new Genre("Ciencia Ficcion"));

            JSONObject jo = ReadJsonFromUrl("https://api.themoviedb.org/3/movie/" + id + "?api_key=c16e8d049b0c5c16b9f10f731876549b&language=es");
            Movie movie = new Movie(jo.getLong("id"), jo.getString("title"),
                    gr, jo.getString("overview"), jo.getString("release_date"),
                    "https://image.tmdb.org/t/p/w500" + jo.getString("poster_path"), null, jo.getInt("vote_average"), 0);
            return movie;
        }
        catch (IOException exIO)
        {

        }
        return null;
    }

    public List<Movie> SearchFilms(String search)
    {
        try
        {
            JSONObject query = ReadJsonFromUrl("https://api.themoviedb.org/3/search/movie?api_key=c16e8d049b0c5c16b9f10f731876549b&language=es&query=" + search.trim().replace(" ", "+"));

            JSONArray jsonArray = query.getJSONArray("results");

            ArrayList<Genre> genresFakes = new ArrayList<Genre>();
            genresFakes.add(new Genre("Drama"));

            ArrayList<JSONObject> arrayList = new ArrayList(jsonArray.length());
            for (int i = 0; i < jsonArray.length(); i++)
            {
                arrayList.add(jsonArray.getJSONObject(i));
            }

            List<Movie> list = new ArrayList<Movie>();
            for (int i = 0; i < arrayList.size(); i++)
            {
                String imgPath;
                try
                {
                    imgPath =  arrayList.get(i).getString("poster_path");
                }
                catch (Exception ex) { imgPath = "";}

                Movie movie = new Movie (arrayList.get(i).getLong("id"), arrayList.get(i).getString("title"),
                        genresFakes, arrayList.get(i).getString("overview"), arrayList.get(i).getString("release_date"),
                        "https://image.tmdb.org/t/p/w500" + imgPath, null, arrayList.get(i).getInt("vote_average"), 0);

                list.add(movie);
            }

            return list;
        }
        catch (IOException exIO)
        {

        }

        return null;
    }


    //Search the Serie with the API. Needs the id known.
    public Serie SearchOneSerieTMDB(String id)
    {
        try
        {
            List<Genre> gr = new ArrayList<Genre>();
            gr.add(new Genre("Ciencia Ficcion"));

            JSONObject jo = ReadJsonFromUrl("https://api.themoviedb.org/3/tv/" + id + "?api_key=c16e8d049b0c5c16b9f10f731876549b&language=es");
            Serie serie = new Serie(jo.getLong("id"), jo.getString("name"),
                    gr, jo.getString("overview"), jo.getString("first_air_date"),
                    "https://image.tmdb.org/t/p/w500" + jo.getString("poster_path"), null, jo.getInt("vote_average"));
            return serie;
        }
        catch (IOException exIO)
        {

        }
        return null;
    }

    public List<Serie> SearchSeries(String search)
    {
        try
        {
            JSONObject query = ReadJsonFromUrl("https://api.themoviedb.org/3/search/tv?api_key=c16e8d049b0c5c16b9f10f731876549b&language=es&query=" + search.trim().replace(" ", "+"));

            JSONArray jsonArray = query.getJSONArray("results");

            ArrayList<Genre> genresFakes = new ArrayList<Genre>();
            genresFakes.add(new Genre("Drama"));

            ArrayList<JSONObject> arrayList = new ArrayList(jsonArray.length());
            for (int i = 0; i < jsonArray.length(); i++)
            {
                arrayList.add(jsonArray.getJSONObject(i));
            }

            List<Serie> list = new ArrayList<Serie>();
            for (int i = 0; i < arrayList.size(); i++)
            {
                String imgPath;
                try
                {
                  imgPath =  arrayList.get(i).getString("poster_path");
                }
                catch (Exception ex) { imgPath = "";}

                Serie serie = new Serie (arrayList.get(i).getLong("id"), arrayList.get(i).getString("name"),
                        genresFakes, arrayList.get(i).getString("overview"), arrayList.get(i).getString("first_air_date"),
                        "https://image.tmdb.org/t/p/w500" + imgPath, null, arrayList.get(i).getInt("vote_average"));

                list.add(serie);
            }

            return list;
        }
        catch (IOException exIO)
        {

        }

        return null;
    }
}
