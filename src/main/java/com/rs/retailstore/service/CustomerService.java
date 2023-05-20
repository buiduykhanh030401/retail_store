package com.rs.retailstore.service;

import com.rs.retailstore.model.Customer;
import com.rs.retailstore.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        String encodePassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encodePassword);
        return customerRepository.save(customer);
    }
}
