package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.employee.dto.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{

  
}
