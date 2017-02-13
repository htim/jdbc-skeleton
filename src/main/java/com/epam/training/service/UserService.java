package com.epam.training.service;

import com.epam.training.dao.UserRepository;
import com.epam.training.domain.User;
import com.epam.training.exception.InvalidPasswordException;
import com.epam.training.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by htim on 11.02.2017.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long id) {
        return userRepository.findOne(id);
    }

    public User findUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }

    public User authenticate(User user) throws UserNotFoundException, InvalidPasswordException {
        User foundUser = this.findUserByLogin(user.getLogin());
        if (foundUser == null) {
            throw new UserNotFoundException();
        }
        if (!foundUser.getPassword().equals(user.getPassword())) {
            throw new InvalidPasswordException();
        }
        return foundUser;
    }
}
