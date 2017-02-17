package by.epam.training.services.impl;

import by.epam.training.beans.User;
import by.epam.training.dao.UserRepository;
import by.epam.training.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Package: by.epam.training.services.impl
 * Project name: SpringDataHibernate
 * Created by Mikita Isakau
 * Creation date: 15.02.2017
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        userRepository.addUser(user);
        return user;
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public void editUser(User user) {
        userRepository.editUser(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }
}
