package daw.spring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

public class TypeCategoryFilm
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany(mappedBy="category")
    @JsonBackReference
    private List<TypeFilm> films;

    public TypeCategoryFilm() {
    }

    public TypeCategoryFilm(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TypeFilm> getFilms() {
        return films;
    }

    public void setFilms(List<TypeFilm> films) {
        this.films = films;
    }
}
