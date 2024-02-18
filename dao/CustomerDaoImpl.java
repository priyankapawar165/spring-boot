package com.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.dto.Customer;
import com.employee.repository.CustomerRepository;

@Component

public class CustomerDaoImpl implements CustomerDao{

  @Autowired
  CustomerRepository customerRepository;

  public List<Customer> getCustomerList(){
    return customerRepository.findAll();
}
  
}
