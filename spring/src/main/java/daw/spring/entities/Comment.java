package daw.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Comment {
	
	//Internal identifier for our databases.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
		
	//Nickname of the user that commented
	private String nickname;
	
	//Profile image of the user that commented
	private String image;
	
	private String message;
	
	//Constructor needed to load from the database
    protected Comment() {}
    
    //Constructor with variables
    public Comment(String nick, String img, String msg) {
    	this.nickname = nick;
    	this.image = img;
    	this.message = msg;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
    //Getter and Setters

    
    
}
