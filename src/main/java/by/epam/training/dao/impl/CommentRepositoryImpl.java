package by.epam.training.dao.impl;

import by.epam.training.beans.Comment;
import by.epam.training.dao.CommentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Package: by.epam.training.dao.impl
 * Project name: SpringDataHibernate
 * Created by Mikita Isakau
 * Creation date: 16.02.2017
 */
@Repository("commentRepository")
public class CommentRepositoryImpl implements CommentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public Comment addComment(Comment comment) {
        return (Comment) getSession().save(comment);
    }

    @Override
    public void delete(int id) {
        getSession().beginTransaction();

        Query query = getSession().createQuery("delete Comment where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();

        getSession().getTransaction().commit();
    }

    @Override
    public Comment findByMessage(String message) {
        Query query = getSession().createQuery("from Comment where message like concat('%', :message, '%')");
        return (Comment) query.getSingleResult();
    }

    @Override
    public Comment editComment(Comment comment) {
        return null;
    }

    @Override
    public List<Comment> getAll() {
        return getSession().createCriteria(Comment.class).list();
    }
}
