package daw.spring.entities;

public class TypeFilm
{

    //External identifier for The Movie Database.
    private int id_external;
    //Internal identifier for our databases.
    private int id_local;
    //Title movie.
    private String title;
    //Category movie.
    private String category;
    //Release date of the film
    private String release_date;
    //Img of the movie.
    private String img;

    public TypeFilm(int id_e, int id_l, String title, String category, String release_date, String img)
    {
        this.id_external = id_e;
        this.id_local = id_l;
        this.title = title;
        this.category = category;
        this.release_date = release_date;
        this.img = img;
    }

    public int Get_IdExternal()
    {
        return this.id_external;
    }

    public void Set_IdExternal(int id)
    {
        this.id_external = id;
    }

    public int Get_IdLocal()
    {
        return this.id_local;
    }

    public void Set_IdLocal(int id)
    {
        this.id_local = id;
    }

    public String Get_Title()
    {
        return this.title;
    }

    public void Set_Title(String title)
    {
        this.title = title;
    }

    public String Get_Category()
    {
        return this.category;
    }

    public void Set_Category(String category)
    {
        this.category = category;
    }

    public String Get_ReleaseDate()
    {
        return this.release_date;
    }

    public void Set_ReleaseDate(String release_date)
    {
        this.release_date = release_date;
    }

    public String Get_Img()
    {
        return this.img;
    }

    public void Set_Img(String img)
    {
        this.img = img;
    }
}
