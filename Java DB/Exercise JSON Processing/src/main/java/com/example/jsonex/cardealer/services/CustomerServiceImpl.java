package com.example.jsonex.cardealer.services;

import com.example.jsonex.cardealer.entities.customer.Customer;
import com.example.jsonex.cardealer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getOrderedCustomers() {
        return this.customerRepository.findAllOrderByBirthDateIsYoungDriver();
    }
}
