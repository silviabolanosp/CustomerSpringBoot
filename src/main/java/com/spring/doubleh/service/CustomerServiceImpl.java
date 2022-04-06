package com.spring.doubleh.service;

import com.spring.doubleh.persistence.dao.CustomerRepository;
import com.spring.doubleh.persistence.model.Customer;
import com.spring.doubleh.web.error.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    private final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);


    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> findAll() {
        return (List<Customer>) repository.findAll();
    }

    public Customer save(Customer newCustomer) {
        return repository.save(newCustomer);
    }

    public Customer findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Customer with id " + id + " not found"));
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


    @Transactional(readOnly = true)
    public Optional<Customer> findOne(Long id) {
        log.debug("Request to get Trade : {}", id);
        return repository.findById(id);
    }
}
