package com.spring.customer.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class AuthoritiesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithQuery(String username, String authority) {
        entityManager.createNativeQuery("INSERT INTO authorities (username, authority) VALUES (?,?)")
                .setParameter(1, username)
                .setParameter(2, authority)
                .executeUpdate();
    }

}
