package com.spring.customer.service;

import com.spring.customer.dao.CustomerRepository;
import com.spring.customer.dao.UserRepository;
import com.spring.customer.model.User;
import com.spring.customer.exception.*;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }


    public User registerNewUserAccount(User user) throws UserAlreadyExistException, PasswordsDontMatchException {
        if (usernameExists(user.getUsername())) {
            throw new UserAlreadyExistException("There is an account with that username: "
                    + user.getUsername());
        }

        if (!user.getPassword().equals(user.getMatchingPassword())) {
            throw new PasswordsDontMatchException("Passwords don't match");
        }

        repository.saveRole(user.getUsername(), "WEBACCESS");
        repository.saveRole(user.getUsername(), "APIACCESS");

        return repository.save(user);
    }

    private boolean usernameExists(String username) {
        return repository.findByUsername(username) != null;
    }
}
