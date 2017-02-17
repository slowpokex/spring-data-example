package by.epam.training.services.impl;

import by.epam.training.beans.Comment;
import by.epam.training.dao.CommentRepository;
import by.epam.training.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Package: by.epam.training.services.impl
 * Project name: SpringDataHibernate
 * Created by Mikita Isakau
 * Creation date: 16.02.2017
 */

@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addComment(Comment comment) {
        Comment savedComment = commentRepository.addComment(comment);
        return savedComment;
    }

    @Override
    public void delete(int id) {
        commentRepository.delete(id);
    }

    @Override
    public Comment getByMessage(String message) {
        return commentRepository.findByMessage(message);
    }

    @Override
    public Comment editComment(Comment comment) {
        return commentRepository.editComment(comment);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.getAll();
    }
}
