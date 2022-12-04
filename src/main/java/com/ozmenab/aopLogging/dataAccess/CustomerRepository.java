package com.ozmenab.aopLogging.dataAccess;

import com.ozmenab.aopLogging.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
