package com.spring.customer.web.controller;

import com.spring.customer.model.User;
import com.spring.customer.web.dto.UserDto;
import com.spring.customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SecurityController {

    @Autowired
    private UserService userService;

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
    public String registerUserDtoAccount(@ModelAttribute("user")  @Valid final UserDto accountDto) {

        final User registered = userService.registerNewUserAccount(accountDto);

        return "redirect:/web/index.html";
    }

}
