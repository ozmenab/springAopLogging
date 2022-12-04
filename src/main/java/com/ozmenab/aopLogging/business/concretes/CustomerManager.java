package com.ozmenab.aopLogging.business.concretes;

import com.ozmenab.aopLogging.business.abstracts.CustomerService;
import com.ozmenab.aopLogging.dataAccess.CustomerRepository;
import com.ozmenab.aopLogging.entities.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public Customer add(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }
}
