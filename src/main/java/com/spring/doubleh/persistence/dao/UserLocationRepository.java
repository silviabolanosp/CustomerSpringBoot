package com.spring.doubleh.persistence.dao;

import com.spring.doubleh.persistence.model.User;
import com.spring.doubleh.persistence.model.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
    UserLocation findByCountryAndUser(String country, User user);

}
