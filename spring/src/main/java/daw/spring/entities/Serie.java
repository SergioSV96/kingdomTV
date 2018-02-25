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
    private String name;

    //Genres of the movie.
    @OneToMany(cascade=CascadeType.ALL)
    private List<Genre> genres;

    //Synopsis of the serie
    private String overview;

    //Release date of the serie
    private String releaseDate;

    //Image of the serie.
    private String poster;

    private int voteAverage;

    //Comment about the serie from an user
    //@OneToMany(mappedBy="serie")
   // private List<Comment> comments;


    //Constructor needed to load from the database
    protected Serie() {}

    //Constructor with variables
    public Serie(long idE, String name, List<Genre> genres, String synopsis, String releaseDate,
                 String poster, List<Comment> comments, int vote_average) {
    	
        this.idExternal = idE;
        this.name = name;
        this.genres = genres;
        this.overview = synopsis;
        this.releaseDate = releaseDate;
        this.poster = poster;
        this.voteAverage = vote_average;
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
		return name;
	}

	public void setTitle(String title) {
		this.name = title;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public String getSynopsis() {
		return overview;
	}

	public void setSynopsis(String synopsis) {
		this.overview = synopsis;
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

    public int getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(int voteAverage) {
        this.voteAverage = voteAverage;
    }

    /*public List<Comment> getComments() {
		return comments;
	}*/

	/*public void setComments(List<Comment> comments) {
		this.comments = comments;
	} */
	
}
