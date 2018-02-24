package daw.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import daw.spring.entities.User;


public interface UserRepository extends CrudRepository<User, Long> {

    User findByNickname(String nickname);

}