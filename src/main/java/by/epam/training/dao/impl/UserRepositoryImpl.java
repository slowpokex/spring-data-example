package by.epam.training.dao.impl;

import by.epam.training.beans.User;
import by.epam.training.dao.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Package: by.epam.training.dao.impl
 * Project name: SpringDataHibernate
 * Created by Mikita Isakau
 * Creation date: 16.02.2017
 */
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    SessionFactory sessionFactory;

    private Session getNewSession() {
        return sessionFactory.openSession();
    }

    @Override
    public void addUser(User user) {
        Session session = getNewSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public User findByLogin(String login) {
        Session session = getNewSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> userRoot = criteria.from(User.class);
        List<User> users = session.createQuery(criteria).list();
        session.close();
        return null;
    }

    @Override
    public void delete(int id) {
        Session session = getNewSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("delete User where id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void editUser(User user) {
        Session session = getNewSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(user);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> getAll() {
        Session session = getNewSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> userRoot = criteria.from(User.class);
        List<User> users = session.createQuery(criteria).list();
        session.close();
        return users;
    }
}
