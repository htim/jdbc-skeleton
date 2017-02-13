package com.epam.training.domain;

import org.hibernate.validator.constraints.Email;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by htim on 11.02.2017.
 */
@Component
public class User {

    private Long id;
    @NotNull
    @Size(min = 3, max = 30)
    private String login;
    @NotNull
    @Size(min = 3, max = 30)
    private String password;
    @Email
    private String email;
    private String role;

    public User() {
    }

    public User(Long id, String login, String password, String email, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
