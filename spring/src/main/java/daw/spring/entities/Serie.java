package daw.spring.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Serie {

	//Internal identifier for our databases.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLocal;

    //External identifier for The Movie Database.
    private long idExternal;

    //Title of the serie.
    private String title;

    //Genres of the movie.
    @OneToMany(cascade=CascadeType.ALL)
    private List<Genre> genres;

    //Synopsis of the serie
    private String synopsis;

    //Release date of the serie
    private String releaseDate;

    //Image of the serie.
    private String poster;

    //Comment about the serie from an user
    //@OneToMany(mappedBy="serie")
   // private List<Comment> comments;


    //Constructor needed to load from the database
    protected Serie() {}

    //Constructor with variables
    public Serie(long idE, String title, List<Genre> genres, String synopsis, String releaseDate,
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

	/*public List<Comment> getComments() {
		return comments;
	}*/

	/*public void setComments(List<Comment> comments) {
		this.comments = comments;
	} */
	
}
