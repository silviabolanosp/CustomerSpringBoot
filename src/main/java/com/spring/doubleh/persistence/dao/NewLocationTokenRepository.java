package com.spring.doubleh.persistence.dao;

import com.spring.doubleh.persistence.model.NewLocationToken;
import com.spring.doubleh.persistence.model.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewLocationTokenRepository extends JpaRepository<NewLocationToken, Long> {

    NewLocationToken findByToken(String token);

    NewLocationToken findByUserLocation(UserLocation userLocation);

}
