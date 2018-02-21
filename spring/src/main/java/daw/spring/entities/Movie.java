package daw.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	
	//Internal identifier for our databases.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLocal;
	
    //External identifier for The Movie Database.
    private long idExternal;
   
    //Title movie.
    private String title;
    
    //Category movie.
    private String category;
    
    //Release date of the film
    private String releaseDate;
    
    //Image of the movie.
    private String img;
    
    //Comment about the movie from an user
    private String commentary;
    
    
    //Constructor needed to load from the database
    protected Movie() {}
    
    //Constructor with variables
    public Movie(long idL, long idE, String title, String category, String releaseDate,
    			String img, String commentary) {
        this.idLocal = idL;
        this.idExternal = idE;
        this.title = title;
        this.category = category;
        this.releaseDate = releaseDate;
        this.img = img;
        this.commentary = commentary;
    }

    
    //Getters and Setters
    
	public long getIdExternal() {
		return idExternal;
	}

	public void setIdExternal(int idExternal) {
		this.idExternal = idExternal;
	}

	public long getIdLocal() {
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

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
	
	
    
}
