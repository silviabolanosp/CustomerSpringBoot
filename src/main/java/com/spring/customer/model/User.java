package com.spring.customer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter

@Table(name="user")
public class User {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @Transient
    private String matchingPassword;
}

