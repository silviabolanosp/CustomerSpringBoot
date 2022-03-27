package com.spring.customer.web.controller;

import java.util.List;

import com.spring.customer.service.CustomerService;
import com.spring.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class CustomerController {


    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/customers")
    public List<Customer> findAll() {
        return service.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/customers")
    public Customer newCustomer(@RequestBody Customer newCustomer) {
        return service.save(newCustomer);
    }

    // Single item

    @GetMapping("/customers/{id}")
    public Customer findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/customers/{id}")
    public Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
        return service.replace(id, newCustomer);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        service.deleteById(id);
    }
}


