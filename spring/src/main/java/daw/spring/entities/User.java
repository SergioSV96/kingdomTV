package daw.spring.entities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	//Internal identifier for our databases.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	//Name
	private String name;
	
	//@nickname
	private String nickname;
	
	//mail@example.com
	private String email;
	
	//Password ********
	private String password;
	
	//Profile image.jpg
	private String image;
	
	//User comments
	@OneToMany(mappedBy="user")
	private List<Comment> comments;
	
	//User type: admin,member,etc. 
	private String type;
	
	//Constructor needed to load from the database
	protected User() {}
	
	//Constructor with variables
	public User(String name, String nick, String email, String pass, String img, String type) {
		this.name = name;
		this.nickname = nick;
		this.email = email;
		this.password = new BCryptPasswordEncoder().encode(pass);
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
