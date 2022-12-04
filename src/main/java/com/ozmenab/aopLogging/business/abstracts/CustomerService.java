package com.ozmenab.aopLogging.business.abstracts;

import com.ozmenab.aopLogging.entities.Customer;

import java.util.List;

public interface CustomerService {
    Customer add(Customer customer);
    List<Customer> getAll();
}
