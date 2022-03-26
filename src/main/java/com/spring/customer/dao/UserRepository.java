package com.spring.customer.dao;

import com.spring.customer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query(value= "INSERT INTO authorities (username, authority) VALUES (?1,?2);", nativeQuery = true)
    void saveRole(String username, String authority);
}
