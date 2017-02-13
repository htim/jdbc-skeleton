package com.epam.training.web.controller;

import com.epam.training.web.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by htim on 11.02.2017.
 */
@Controller
public class IndexController {

    @Autowired
    private UserManager userManager;

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        return "index";
    }
}
