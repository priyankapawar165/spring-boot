package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.CustomerDao;
import com.employee.dto.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

@Autowired
CustomerDao customerDao;

public List <Customer> getCustomerList(){
  return customerDao.getCustomerList();
}

public Customer addCustomer (Customer customer){
  return customerDao.addCustomer(customer);
}  
}
