package daw.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import daw.spring.entities.Genre;


public interface CommentRepository extends JpaRepository<Genre, Long> {

}