package daw.spring.entities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class TypeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String passwordHash;
    private String email;
    private String image;
    private boolean activatedUser;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    public TypeUser() { }

    public TypeUser(String name, String email, String passwordHash, boolean activedUser, List<String> roles)
    {
        this.name = name;
        this.email = email;
        this.roles = roles;
        this.activatedUser = activedUser;
        this.passwordHash = new BCryptPasswordEncoder().encode(passwordHash);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isActivatedUser() {
        return activatedUser;
    }

    public void setActivatedUser(boolean activatedUser) {
        this.activatedUser = activatedUser;
    }

}
