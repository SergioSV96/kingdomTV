package daw.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Genre {
	
	//Internal identifier for our databases.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	//Genre name (Action, Drama, etc.)
	private String name;
	
	//Constructor needed to load from the database
	protected Genre() {}
	
	//Constructor with variables
	public Genre(String name) {
		this.name = name;
	}
	

	//Getters and Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
