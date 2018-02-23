package daw.spring.repository;

import daw.spring.entities.TypeCategoryFilm;
import daw.spring.entities.TypeFilm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FilmRepository extends JpaRepository<TypeFilm, Long>
{
    Page<TypeFilm> findAll(Pageable pageable);
    Page<TypeFilm> findByGenre(Pageable pageable, TypeCategoryFilm genre);

}
