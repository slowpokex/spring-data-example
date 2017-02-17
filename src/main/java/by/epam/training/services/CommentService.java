package by.epam.training.services;

import by.epam.training.beans.Comment;

import java.util.List;

/**
 * Package: by.epam.training.services
 * Project name: SpringDataHibernate
 * Created by Mikita Isakau
 * Creation date: 15.02.2017
 */
public interface CommentService {
    Comment addComment(Comment comment);
    void delete(int id);
    Comment getByMessage(String message);
    Comment editComment(Comment comment);
    List<Comment> getAll();
}
