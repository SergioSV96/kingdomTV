package daw.spring.entities;

public class TypeFilm {

    //External identifier for The Movie Database.
    private int idExternal;
    //Internal identifier for our databases.
    private int idLocal;
    //Title movie.
    private String title;
    //Category movie.
    private String category;
    //Release date of the film
    private String releaseDate;
    //Image of the movie.
    private String img;

    public TypeFilm(int idE, int idL, String title, String category, String releaseDate, String img) {
        this.idExternal = idE;
        this.idLocal = idL;
        this.title = title;
        this.category = category;
        this.releaseDate = releaseDate;
        this.img = img;
    }

	public int getIdExternal() {
		return idExternal;
	}

	public void setIdExternal(int idExternal) {
		this.idExternal = idExternal;
	}

	public int getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
    
}
