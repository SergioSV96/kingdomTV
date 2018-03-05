package daw.spring.repositories;

import daw.spring.entities.Comment;
import daw.spring.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import daw.spring.entities.Genre;

import java.util.ArrayList;
import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long>
{

    List<Comment> findByItem_id(String id);

    @Override
    Comment findOne(Long aLong);


}