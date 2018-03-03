package daw.spring.repositories;


import daw.spring.entities.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import daw.spring.entities.Movie;


public interface MovieRepository extends JpaRepository<Movie, Long>
{
    Page<Movie> findAll(Pageable pageable);
}
