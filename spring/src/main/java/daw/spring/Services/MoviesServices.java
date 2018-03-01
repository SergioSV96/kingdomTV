package daw.spring.Services;

import daw.spring.entities.Movie;
import daw.spring.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServices {

    @Autowired
    private MovieRepository movieRepository;

    public Page<Movie> getAllFilms(Pageable page) {
        return movieRepository.findAll(page);
    }

    public List<Movie> getAllFilms() {
        return movieRepository.findAll();
    }

    public Movie findOne(long id) {
        return movieRepository.findOne(id);
    }


}
