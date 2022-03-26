package com.spring.customer.model;

import lombok.*;

import java.util.Collection;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    private String username;

    private String password;

    private boolean enabled;

    @Transient
    private String matchingPassword;



}
