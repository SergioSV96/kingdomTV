package daw.spring.repositories;


import daw.spring.entities.Serie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SerieRepository extends JpaRepository<Serie, Long>
{
   // Serie findByGenre(Pageable page, Genre genre);
}
