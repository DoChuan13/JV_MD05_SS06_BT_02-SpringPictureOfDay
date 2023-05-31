package backend.service;

import backend.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();

    void save(Comment comment);
    Comment findById(Long id);
}
