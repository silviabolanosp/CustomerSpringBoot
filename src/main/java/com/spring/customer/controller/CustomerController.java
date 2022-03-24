package com.spring.customer.controller;

import java.util.List;

import com.spring.customer.service.CustomerService;
import com.spring.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/customers")
    List<Customer> findAll() {
        return service.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/customers")
    Customer newCustomer(@RequestBody Customer newCustomer) {
        return service.save(newCustomer);
    }

    @PostMapping("/customers/add")
    void newCustomer() {
        service.addCustomers();
    }

    // Single item

    @GetMapping("/customers/{id}")
    Customer findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/customers/{id}")
    Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
        return service.replace(id, newCustomer);
    }

    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable Long id) {
        service.deleteById(id);
    }
}


