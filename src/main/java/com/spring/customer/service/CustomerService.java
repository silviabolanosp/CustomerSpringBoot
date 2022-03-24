package com.spring.customer.service;

import com.spring.customer.model.Customer;

import java.util.List;


public interface CustomerService {
    List<Customer> findAll();
    Customer save(Customer newCustomer);
    Customer findById(Long id);
    Customer replace(Long id, Customer newCustomer);
    void deleteById(Long id);
}
