package com.employee.service;

import java.util.List;

import com.employee.dto.Customer;

public interface CustomerService {
  public List <Customer> getCustomerList();

  public Customer addCustomer(Customer customer);
  
}
