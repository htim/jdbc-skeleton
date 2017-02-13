package com.epam.training.web.manager;

import com.epam.training.domain.User;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 * Created by htim on 11.02.2017.
 */
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class UserManager {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
