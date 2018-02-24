package daw.spring.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import daw.spring.entities.User;
import daw.spring.repositories.UserRepository;

@Component
public class DatabaseUsersLoader {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void initDatabase() {
    	
    	//User(String name, String nick, String email, String pass, String img, String... roles)
    	userRepository.save(new User("User", "user", "email", "pass", "", "ROLE_USER"));
		userRepository.save(new User("Admin", "admin", "pass", "", "ROLE_USER", "ROLE_ADMIN"));
    }

}
