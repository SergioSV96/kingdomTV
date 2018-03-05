package daw.spring.entities;

import javax.persistence.*;


@Entity
public class Comment {
	
	//Internal identifier for our databases.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;


	private long user;

	private String item_id; //M-001, S-001

	private String message;

	public Comment(long user, String item_id, String message)
    {
        this.user = user;
        this.item_id = item_id;
        this.message = message;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
