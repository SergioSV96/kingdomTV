package daw.spring.Services;


import daw.spring.entities.TypeCategoryFilm;
import daw.spring.entities.TypeFilm;
import daw.spring.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServices
{

    @Autowired
    private FilmRepository filmRepository;

    public Page<TypeFilm> getAllFilms(Pageable page) {
        return filmRepository.findAll(page);
    }

    public List<TypeFilm> getAllPFilms() {
        return  filmRepository.findAll();
    }

    public TypeFilm findOne(long id) {
        return filmRepository.findOne(id);
    }

    public Page<TypeFilm> getAllByGenre(Pageable page, TypeCategoryFilm cat) {
        return filmRepository.findByGenre(page, cat);
    }

}
