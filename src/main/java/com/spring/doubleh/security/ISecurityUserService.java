package com.spring.doubleh.security;

public interface ISecurityUserService {

    String validatePasswordResetToken(String token);

}
