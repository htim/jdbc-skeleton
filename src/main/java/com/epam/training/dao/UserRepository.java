package com.epam.training.dao;

import com.epam.training.dao.CrudRepository;
import com.epam.training.domain.User;

/**
 * Created by htim on 11.02.2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByLogin(String login);
}
