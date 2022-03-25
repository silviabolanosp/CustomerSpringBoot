package com.spring.customer.service;

import com.spring.customer.dao.UserRepository;
import com.spring.customer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.customer.exception.*;

public class UserServiceImpl {

    @Autowired
    private UserRepository repository;


    public User registerNewUserAccount(User user) throws UserAlreadyExistException, PasswordsDontMatchException {
        if (emailExists(user.getUsername())) {
            throw new UserAlreadyExistException("There is an account with that username: "
                    + user.getUsername());
        }

        if (user.getPassword().equalsIgnoreCase(user.getMatchingPassword())) {
            throw new PasswordsDontMatchException("Passwords don't match");
        }

        repository.saveRole(user.getUsername(), "WEBACCESS");
        repository.saveRole(user.getUsername(), "APIACCESS");

        return repository.save(user);
    }

    private boolean emailExists(String username) {
        return repository.findByUsername(username) != null;
    }
}
