package com.epam.training.web.interceptor;

import com.epam.training.web.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by htim on 11.02.2017.
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserManager userManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (userManager.getUser() == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
