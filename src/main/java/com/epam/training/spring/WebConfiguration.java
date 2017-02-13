package com.epam.training.spring;

import com.epam.training.web.interceptor.AuthInterceptor;
import com.epam.training.web.interceptor.UserAddingHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by htim on 11.02.2017.
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Autowired
    private UserAddingHandlerInterceptor userAddingHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/cars/**");
        registry.addInterceptor(userAddingHandlerInterceptor)
                .addPathPatterns("/**");
    }
}
