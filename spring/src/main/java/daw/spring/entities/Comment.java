package daw.spring.entities;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Comment {
	
	//Internal identifier for our databases.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
		
	//User that commented
	@ManyToOne
	private User user;
	
	//Movie commented
	@ManyToOne
	private Movie movie;
	
	//Message written
	private String message;
	
	//Constructor needed to load from the database
    protected Comment() {}
    
    //Constructor with variables
    public Comment(User user, String msg) {
    	this.user = user;
    	this.message = msg;
    }
    
    
    //Getters and Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

    
}
