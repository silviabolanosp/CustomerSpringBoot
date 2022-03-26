package com.spring.customer.controller;

import com.spring.customer.exception.PasswordsDontMatchException;
import com.spring.customer.exception.UserAlreadyExistException;
import com.spring.customer.model.User;
import com.spring.customer.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SecurityController {

    private UserService service;

    public SecurityController(UserService service) {
        this.service = service;
    }


    @GetMapping("/login.html")
    public String showLogin(){
        return "login.html";
    }

    @GetMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }

    @GetMapping("/accessDenied.html")
    public String showAccessDenied(Model model){
        model.addAttribute("accessError", true);

        return "login.html";
    }

    @GetMapping("/user/registration")
    public String showRegistration(Model model){
        model.addAttribute("user", new User());
        return "registration.html";
    }


    @PostMapping("/user/registration")
    public String registerUserDtoAccount(@ModelAttribute("user")  User user, HttpServletRequest request, Errors errors) {
        user.setEnabled(true);
        ModelAndView mav = new ModelAndView();
        try {
            User registered = service.registerNewUserAccount(user);
        } catch (UserAlreadyExistException uaeEx) {
            mav.addObject("message", "An account for that username already exists.");
            //return mav;
        } catch (PasswordsDontMatchException pdmEx) {
            mav.addObject("message", "Passwords don't match.");
            //return mav;
        }

        return "redirect:/web/index.html";
    }

}
