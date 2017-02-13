package com.epam.training.web.interceptor;

import com.epam.training.web.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by htim on 11.02.2017.
 */
@Component
public class UserAddingHandlerInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserManager userManager;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            modelAndView.getModel().put("user", userManager.getUser());
        }
    }
}
