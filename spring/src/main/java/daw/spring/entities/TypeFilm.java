package daw.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class TypeFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //Internal identifier for our databases.
    private int id_local;
    //External identifier for The Movie Database.
    private int id;
    //Title movie.
    private String title;
    //Genre movie.
    private String genre;
    //Release date of the film
    private String release_date;
    //Img of the movie.
    private String poster_path;
    //Overview of the film.
    private String overview;

    public TypeFilm() {
    }

    public TypeFilm(int id_e, String title, String genre, String release_date, String img) {
        this.id = id_e;
        this.title = title;
        this.genre = genre;
        this.release_date = release_date;
        this.poster_path = img;
    }

    public TypeFilm(int id_e, int id_l, String title, String genre, String release_date, String img) {
        this.id = id_e;
        this.id_local = id_l;
        this.title = title;
        this.genre = genre;
        this.release_date = release_date;
        this.poster_path = img;
    }

    public int Get_IdExternal() {
        return this.id;
    }

    public void Set_IdExternal(int id) {
        this.id = id;
    }

    public int Get_IdLocal() {
        return this.id_local;
    }

    public void Set_IdLocal(int id) {
        this.id_local = id;
    }

    public String Get_Title() {
        return this.title;
    }

    public void Set_Title(String title) {
        this.title = title;
    }

    public String Get_Category() {
        return this.genre;
    }

    public void Set_Category(String category) {
        this.genre = category;
    }

    public String Get_ReleaseDate() {
        return this.release_date;
    }

    public void Set_ReleaseDate(String release_date) {
        this.release_date = release_date;
    }

    public String Get_Img() {
        return this.poster_path;
    }

    public void Set_Img(String img) {
        this.poster_path = img;
    }
}
