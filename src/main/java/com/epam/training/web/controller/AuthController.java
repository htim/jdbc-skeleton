package com.epam.training.web.controller;

import com.epam.training.domain.User;
import com.epam.training.exception.InvalidPasswordException;
import com.epam.training.exception.UserNotFoundException;
import com.epam.training.service.UserService;
import com.epam.training.web.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by htim on 11.02.2017.
 */
@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserManager userManager;

    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String authorize(@Valid User user, BindingResult bindingResult) throws UserNotFoundException, InvalidPasswordException {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        User foundUser = userService.authenticate(user);
        userManager.setUser(foundUser);
        return "redirect:/index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFoundException(Model model) {
        model.addAttribute("error", "loginError");
        model.addAttribute("user", new User());
        return "login";
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public String handleInvalidPasswordException(Model model) {
        model.addAttribute("error", "passwordError");
        model.addAttribute("user", new User());
        return "login";
    }
}
