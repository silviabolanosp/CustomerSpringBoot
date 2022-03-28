package com.spring.doubleh.persistence.dao;

import com.spring.doubleh.persistence.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
