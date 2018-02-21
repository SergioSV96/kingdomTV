package daw.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import daw.spring.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {

}