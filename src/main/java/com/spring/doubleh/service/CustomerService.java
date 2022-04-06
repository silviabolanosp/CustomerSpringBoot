package com.spring.doubleh.service;

import com.spring.doubleh.persistence.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAll();
    Customer save(Customer newCustomer);
    Customer findById(Long id);
    Customer replace(Long id, Customer newCustomer);
    void deleteById(Long id);
    Optional<Customer> findOne(Long id);
}
