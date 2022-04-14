package com.example.jsonex.cardealer.services;

import com.example.jsonex.cardealer.entities.customer.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getOrderedCustomers();
}
