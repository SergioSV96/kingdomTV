package daw.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import daw.spring.entities.Movie;


public interface MovieRepository extends JpaRepository<Movie, Long> {

}
