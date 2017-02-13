package com.epam.training.dao.impl;

import com.epam.training.dao.UserRepository;
import com.epam.training.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by htim on 11.02.2017.
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public User findUserByLogin(String login) {
        try {
            User user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE login = ?", this::mapRow, login);
            return user;
        } catch (EmptyResultDataAccessException ignored) {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    @Override
    public void delete(User entity) {
        delete(entity.getId());
    }

    @Override
    public boolean exists(Long id) {
        try {
            Long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users WHERE id=?", Long.class, id);
            return count != null && count > 0;
        } catch (EmptyResultDataAccessException ignored) {
            return false;
        }
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users", this::mapRow);
    }

    @Override
    public User findOne(Long id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", this::mapRow, id);
        } catch (EmptyResultDataAccessException ignored) {
            return null;
        }
    }

    @Override
    public User save(User entity) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(entity);
        if (entity.getId() == null) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            namedParameterJdbcTemplate.update("INSERT INTO users VALUES (:id, :login, :email, :password, :role)", params, keyHolder);
            entity.setId(keyHolder.getKey().longValue());
        } else {
            namedParameterJdbcTemplate.update(
                    "UPDATE users SET " +
                    "login = :login, " +
                    "email = :email, " +
                    "password = :password, " +
                    "role = :role",
                    params);
        }
        return entity;
    }

    @Override
    public List<User> save(List<User> entity) {
        throw new UnsupportedOperationException();
    }

    private User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setLogin(rs.getString("login"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("role"));
        return user;
    }
}
