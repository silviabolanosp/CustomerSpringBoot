package com.spring.customer.service;

import com.spring.customer.exception.CustomerNotFoundException;
import com.spring.customer.model.Customer;
import com.spring.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository repository;

    public List<Customer> findAll() {
        return (List<Customer>) repository.findAll();
    }

    public Customer save(Customer newCustomer) {
        return repository.save(newCustomer);
    }

    public Customer findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public Customer replace(Long id, Customer newCustomer) {
        return repository.findById(id)
                .map(Customer -> {
                    Customer.setFirstName(newCustomer.getFirstName());
                    Customer.setLastName(newCustomer.getLastName());
                    return repository.save(Customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return repository.save(newCustomer);
                });
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void addCustomers(){
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));
    }
}
