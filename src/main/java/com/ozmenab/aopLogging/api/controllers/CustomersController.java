package com.ozmenab.aopLogging.api.controllers;

import com.ozmenab.aopLogging.business.abstracts.CustomerService;
import com.ozmenab.aopLogging.entities.Customer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomersController {
    private CustomerService customerService;

    @PostMapping
    public Customer add(@RequestBody Customer customer){
        return customerService.add(customer);
    }

    @GetMapping
    public List<Customer> getAll(){
        return customerService.getAll();
    }
}
