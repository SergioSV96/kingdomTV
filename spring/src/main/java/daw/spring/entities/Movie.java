package daw.spring.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Movie {
	
	//Internal identifier for our databases.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLocal;
	
    //External identifier for The Movie Database.
    private long idExternal;
   
    //Title of the movie.
    private String title;
    
    //Genres of the movie.
    @OneToMany(mappedBy="movie")
    private List<Genre> genres;
    
    //Synopsis of the movie
    private String synopsis;
    
    //Release date of the film
    private String releaseDate;
    
    //Image of the movie.
    private String poster;
    
    //Comment about the movie from an user
    @OneToMany(mappedBy="comment")
    private List<Comment> comments;
    
    
    //Constructor needed to load from the database
    protected Movie() {}
    
    //Constructor with variables
    public Movie(long idE, String title, List<Genre> genres, String synopsis, String releaseDate,
    			String poster, List<Comment> comments) {
    	
        this.idExternal = idE;
        this.title = title;
        this.genres = genres;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
        this.poster = poster;
    }

    
    //Getters and Setters
    
	public long getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(long idLocal) {
		this.idLocal = idLocal;
	}

	public long getIdExternal() {
		return idExternal;
	}

	public void setIdExternal(long idExternal) {
		this.idExternal = idExternal;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}    
	
}
