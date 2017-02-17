package by.epam.training.services;

import by.epam.training.beans.User;

import java.util.List;

/**
 * Package: by.epam.training.services
 * Project name: SpringDataHibernate
 * Created by Mikita Isakau
 * Creation date: 15.02.2017
 */
public interface UserService {
    User addUser(User user);
    void delete(int id);
    User getByLogin(String login);
    void editUser(User user);
    List<User> getAll();
}
