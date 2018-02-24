package daw.spring.entities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private String passwordHash;
	
	//Profile image.jpg
	private String image;
	
	//User's roles
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	//User comments
	@OneToMany(mappedBy="user")
	private List<Comment> comments;
	

	//Constructor needed to load from the database
	protected User() {}
	
	//Constructor with variables
	public User(String name, String nick, String email, String pass, String img, String... roles) {
		this.name = name;
		this.nickname = nick;
		this.email = email;
		this.passwordHash = new BCryptPasswordEncoder().encode(pass);
		this.roles = new ArrayList<>(Arrays.asList(roles));
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

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String password) {
		this.passwordHash = password;
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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	
	
	

}
