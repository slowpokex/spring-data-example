package by.epam.training.dao;

import by.epam.training.beans.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Package: by.epam.training.dao
 * Project name: SpringDataHibernate
 * Created by Mikita Isakau
 * Creation date: 15.02.2017
 */

public interface CommentRepository {
    Comment addComment(Comment comment);
    void delete(int id);
    Comment findByMessage(String message);
    Comment editComment(Comment comment);
    List<Comment> getAll();
}
