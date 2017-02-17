package by.epam.training.dao;

import by.epam.training.beans.User;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Package: by.epam.training.dao
 * Project name: SpringDataHibernate
 * Created by Mikita Isakau
 * Creation date: 15.02.2017
 */

public interface UserRepository {
    void addUser(User user);
    User findByLogin(String login);
    void delete(int id);
    void editUser(User user);
    List<User> getAll();

}
