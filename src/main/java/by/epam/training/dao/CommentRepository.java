package by.epam.training.dao;

import by.epam.training.beans.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Package: by.epam.training.dao
 * Project name: SpringDataHibernate
 * Created by Mikita Isakau
 * Creation date: 15.02.2017
 */

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Comment findByMessage(String message);
}
