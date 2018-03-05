package daw.spring.Services;

import daw.spring.entities.Comment;
import daw.spring.entities.Movie;
import daw.spring.repositories.CommentRepository;
import daw.spring.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommentServices {


    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getCommentsFromFilm(String id)
    {
        return commentRepository.findByItem_id(id);
    }

}
