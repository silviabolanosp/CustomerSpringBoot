package com.spring.customer.service;

import com.spring.customer.model.User;
import com.spring.customer.web.dto.UserDto;

public interface UserService {
    User registerNewUserAccount(UserDto accountDto);
}
